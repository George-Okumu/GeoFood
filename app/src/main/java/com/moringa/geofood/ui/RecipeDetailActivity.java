package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.moringa.geofood.R;
import com.moringa.geofood.Recipe;
import com.moringa.geofood.services.EdamamService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RecipeDetailActivity extends AppCompatActivity {
    private static final String TAG = "";

    @BindView(R.id.recipeTextView) TextView mRecipeTextView;
    @BindView(R.id.listView) ListView mListView;

    ArrayList<Recipe> allRecipes = new ArrayList<>();


//    private String[] recipes = new String[] {"Mi Mero Mole", "Mother's Bistro",
//            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
//            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
//            "Lardo", "Portland City Grill", "Fat Head's Brewery",
//            "Chipotle", "Subway"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

//        RecipeListAdapter adapter = new RecipeListAdapter(RecipeDetailActivity.this, android.R.layout.simple_list_item_1, recipes);
//        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String recipe = intent.getStringExtra("recipe");
        mRecipeTextView.setText("Here are all your recipe" + recipe);
        getRecipes("pizza");


    }

    private void getRecipes(String searchQuery){
        final EdamamService edamamService = new EdamamService();
        edamamService.findRecipes(searchQuery, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                allRecipes = EdamamService.processResults(response);
                RecipeDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] allRecipeTitle = new String[allRecipes.size()];
                        for(int w = 0; w< allRecipeTitle.length; w++){
                            allRecipeTitle[w] = allRecipes.get(w).getTitle();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(RecipeDetailActivity.this,  android.R.layout.simple_list_item_1, allRecipeTitle);
                        mListView.setAdapter(adapter);

                        for(Recipe recipe : allRecipes){
                            Log.d(TAG, "Title"+ recipe.getTitle());
                            Log.d(TAG, "Cuisine" + recipe.getCuisine());
                            Log.d(TAG, "Calories" + recipe.getCalories());
                            Log.d(TAG, "serving" + recipe.getServings());
                        }
                    }
                });
            }
        });
    }
}