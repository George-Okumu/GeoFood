package com.moringa.geofood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.moringa.geofood.Services.EdamamService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
                try{
                    String jsonData = response.body().string();
                    Log.d(TAG, jsonData);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}