package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;


import com.moringa.geofood.R;
import com.moringa.geofood.adapters.RecipeListAdapter;
import com.moringa.geofood.models.Recipe;
import com.moringa.geofood.services.EdamamService;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class EdamamSearchActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rvApiRecipesList) RecyclerView rvApiRecipesList;
    private RecipeListAdapter mAdapter;
    public List<Recipe> recipes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edanam_search);

        ButterKnife.bind(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getRecipes(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

    private void getRecipes(String searchQuery){
        final EdamamService edamamService = new EdamamService();
        edamamService.findRecipes(searchQuery, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: I am the error",  e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                recipes = edamamService.processResults(response);
                if(recipes.size() == 0){
                    EdamamSearchActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(EdamamSearchActivity.this, "No recipes found", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(EdamamSearchActivity.this, EdamamSearchActivity.class);
                            startActivity(intent);
                        }
                    });
                }else{
                    EdamamSearchActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new RecipeListAdapter(getApplicationContext(), recipes);
                            rvApiRecipesList.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EdamamSearchActivity.this);
                            rvApiRecipesList.setLayoutManager(layoutManager);
                            rvApiRecipesList.setHasFixedSize(true);
                        }
                    });
                }
            }
        });
    }

}