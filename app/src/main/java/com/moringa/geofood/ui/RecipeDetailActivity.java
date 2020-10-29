package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.moringa.geofood.R;
import com.moringa.geofood.adapters.RecipeListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends AppCompatActivity {

    private static final String TAG = "";

    @BindView(R.id.recipeTextView) TextView mRecipeTextView;
    @BindView(R.id.listView) ListView mListView;


    private String[] recipe = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        RecipeListAdapter adapter = new RecipeListAdapter(RecipeDetailActivity.this, android.R.layout.simple_list_item_1, recipe);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String recipe = intent.getStringExtra("recipe");
        mRecipeTextView.setText("Here are all your recipe" + recipe);
//        getRecipes("pizza");

    }
}