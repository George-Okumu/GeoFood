package com.moringa.geofood.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringa.geofood.Constants;
import com.moringa.geofood.R;
import com.moringa.geofood.model.Meal;
import com.moringa.geofood.ui.RecipeDetail02Activity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public FirebaseRecipeViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }


    public void bindRecipe(Meal meals){

      ImageView recipeSavedImageView = (ImageView) mView.findViewById(R.id.recipeSavedImageView);
      TextView recipeSavedNameTextView = (TextView) mView.findViewById(R.id.recipeSavedNameTextView);
      TextView categorySavedTextView = (TextView) mView.findViewById(R.id.categorySavedTextView);

        Picasso.get().load(meals.getStrMealThumb()).into(recipeSavedImageView);

        recipeSavedNameTextView.setText(meals.getStrMeal());
        categorySavedTextView.setText(meals.getStrCategory());
    }


    @Override
    public void onClick(View v) {
        final ArrayList<Meal> meals = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    meals.add(snapshot.getValue(Meal.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, RecipeDetail02Activity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("meals", Parcels.wrap(meals));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
