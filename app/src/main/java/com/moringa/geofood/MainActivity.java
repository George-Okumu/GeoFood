package com.moringa.geofood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.recipeEditText) EditText mRecipeEditText;
    @BindView(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == mSearchButton){
            String recipe =mRecipeEditText.getText().toString();

            Intent intent = new Intent(MainActivity.this, RecipeDetailActivity.class);
            intent.putExtra("recipe", recipe);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
        }
    }
}