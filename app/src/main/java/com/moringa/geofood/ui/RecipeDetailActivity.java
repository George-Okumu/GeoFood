package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringa.geofood.model.Meal;
import com.moringa.geofood.network.MealApi;
import com.moringa.geofood.network.MealClient;
import com.moringa.geofood.model.MealDB;
import com.moringa.geofood.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeDetailActivity extends AppCompatActivity {

    private static final String TAG = "";

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @BindView(R.id.recipeTextView) TextView mRecipeTextView;
    @BindView(R.id.listView) ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);


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

                        ArrayAdapter adapter = new ArrayAdapter(RecipeDetailActivity.this, android.R.layout.simple_list_item_1, instructions);
                        mListView.setAdapter(adapter);
                        Log.d(TAG, "onResponse: " + adapter);

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

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again!");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showRecipe() {
        mListView.setVisibility(View.VISIBLE);
        mRecipeTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}