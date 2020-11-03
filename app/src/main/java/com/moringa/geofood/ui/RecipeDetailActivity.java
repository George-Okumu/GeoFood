package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringa.geofood.Constants;
import com.moringa.geofood.adapters.RecipeListAdapter;
import com.moringa.geofood.model.Meal;
import com.moringa.geofood.network.MealApi;
import com.moringa.geofood.network.MealClient;
import com.moringa.geofood.model.MealDB;
import com.moringa.geofood.R;
import com.moringa.geofood.util.OnRecipeSelectedListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeDetailActivity extends AppCompatActivity  implements OnRecipeSelectedListener {

    private static final String TAG = "";

    String mSource;
    private Integer mPosition;

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    public List<Meal> mMeals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        if(savedInstanceState != null){
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                mSource = savedInstanceState.getString(Constants.KEY_SOURCE);

                if(mPosition != null ){
                    Intent intent = new Intent(this, RecipeDetail02Activity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                    intent.putExtra(Constants.EXTRA_KEY_RECIPES, Parcels.wrap(mMeals));
                    startActivity(intent);
                }

            }
        }


        MealApi client = MealClient.getClient();
        Call<MealDB> call = client.getRandomMeals();

        call.enqueue(new Callback<MealDB>() {
            @Override
            public void onResponse(Call<MealDB> call, Response<MealDB> response) {
                Log.d(TAG, "onResponse: Success");
                hideProgressBar();
                if(response.isSuccessful()){
                    List<Meal> meals = response.body().getMeals();

                    String[] mealName = new String[meals.size()];
                    String[] instructions = new String[meals.size()];

                    for(int i = 0; i < mealName.length; i++){
                        mealName[i] = meals.get(i).getStrMeal();
                    }

                    for(int i = 0; i <instructions.length; i++){
                        instructions[i] = meals.get(i).getStrInstructions();

                        mAdapter = new RecipeListAdapter(RecipeDetailActivity.this, meals);
                        mRecyclerView.setAdapter(mAdapter);

                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeDetailActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                        Log.d(TAG, "onResponse: " + mAdapter);

                        showRecipe();
                    }
                }else{
                    showUnsuccessfulMessage();
                }

            }

            @Override
            public void onFailure(Call<MealDB> call, Throwable t) {
                Log.d(TAG, "onFailure: Error");
                hideProgressBar();
                showFailureMessage();
            }
        });

    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        ...
//        if (mPosition != null && mRestaurants != null) {
//            ...
//            outState.putString(Constants.KEY_SOURCE, mSource);
//        }
//    }
//
//    @Override
//    public void onRestaurantSelected(Integer position, ArrayList<Restaurant> restaurants, String source) {
//        ...
//        mSource = source;
//    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again!");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showRecipe() {
        mRecyclerView.setVisibility(View.VISIBLE);

    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onRecipeSelected(Integer position, ArrayList<Meal> meals, String source) {

        mPosition = position;
        mMeals = meals;
    }
}