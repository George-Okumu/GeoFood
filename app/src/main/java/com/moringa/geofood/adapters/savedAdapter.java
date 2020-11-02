package com.moringa.geofood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.moringa.geofood.R;
import com.moringa.geofood.model.Meal;

public class savedAdapter extends FirebaseRecyclerAdapter<Meal, savedAdapter.MealsViewholder> {

    public savedAdapter(FirebaseRecyclerOptions<Meal> options){
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull savedAdapter.MealsViewholder holder, int position, @NonNull Meal model) {
//        holder.recipeSavedImageView.setText(model.getStrMealThumb());
        holder.recipeSavedNameTextView.setText(model.getStrMeal());
        holder.categorySavedTextView.setText(model.getStrCategory());

    }


    @NonNull
    @Override
    public savedAdapter.MealsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_recipe, parent, false);
        return new MealsViewholder(view);
    }

    static class MealsViewholder extends RecyclerView.ViewHolder{
//        TextView recipeSavedImageView;
        TextView recipeSavedNameTextView;
        TextView categorySavedTextView;

        public MealsViewholder(View itemView){
            super(itemView);

//            recipeSavedImageView = itemView.findViewById(R.id.recipeSavedImageView);
            recipeSavedNameTextView = itemView.findViewById(R.id.recipeSavedNameTextView);
            categorySavedTextView = itemView.findViewById(R.id.categorySavedTextView);
        }
    }
}
