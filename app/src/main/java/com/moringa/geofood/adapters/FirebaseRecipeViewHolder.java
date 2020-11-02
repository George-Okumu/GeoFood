package com.moringa.geofood.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
import java.util.List;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View  mView;
    Context mContext;

    public FirebaseRecipeViewHolder (View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);

    }

    public void bindMeal(Meal meals){
        ImageView recipeImageView = (ImageView) mView.findViewById(R.id.recipeImageView);
        TextView  recipeNameTextView = (TextView) mView.findViewById(R.id.recipeNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView instructionsTextView = (TextView) mView.findViewById(R.id.instructionsTextView);

        Picasso.get().load(meals.getStrMealThumb()).into(recipeImageView);

        recipeNameTextView.setText(meals.getStrMeal());
        categoryTextView.setText(meals.getStrCategory());
        instructionsTextView.setText(meals.getStrInstructions());

    }
    @Override
    public void onClick(View v) {
        final ArrayList<Meal> meals = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPES);

        //Grabbing Current List Frm Firebase
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    meals.add(dataSnapshot.getValue(Meal.class));
                }
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, RecipeDetail02Activity.class);
                intent.putExtra("position", itemPosition + " ");
                intent.putExtra("meals", Parcels.wrap(meals));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
