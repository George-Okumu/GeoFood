package com.moringa.geofood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.geofood.R;
import com.moringa.geofood.model.Meal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private List<Meal> mStrMeal ;
    private Context mContext;

    public RecipeListAdapter(Context context, List<Meal> meals){
        mContext = context;
        mStrMeal = meals;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bindRecipe(mStrMeal.get(position));

    }

    @Override
    public int getItemCount() {
        return mStrMeal.size();
    }

    public class RecipeViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
        @BindView(R.id.categoryTextView) TextView mRecipeCategoryTextView;
        @BindView(R.id.instructionsTextView) TextView mInstructionsTextView;


        private Context mContext;

        public RecipeViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bindRecipe(Meal meals){
            mRecipeNameTextView.setText(meals.getStrMeal());
            mRecipeCategoryTextView.setText(meals.getStrCategory());
            mInstructionsTextView.setText(meals.getStrInstructions());
        }
    }

}
