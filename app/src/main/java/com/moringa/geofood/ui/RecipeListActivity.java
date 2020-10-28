package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.moringa.geofood.R;
import com.moringa.geofood.adapters.RecipeListAdapter;
import com.moringa.geofood.models.Recipe;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    List<Recipe> recipes;
    RecipeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Intent intent = getIntent();
        String cuisine = intent.getStringExtra("cuisine");

//        recipes = Recipe.createRecipeList();

        RecyclerView geoRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
        adapter = new RecipeListAdapter(RecipeListActivity.this, recipes);
        geoRecipes.setLayoutManager(new LinearLayoutManager(this));
        geoRecipes.setAdapter(adapter);
    }
}