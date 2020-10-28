package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.moringa.geofood.R;

public class CuisineListActivity extends AppCompatActivity {

    private ListView mCuisineListView;
    private String[] cuisines = new String[] {"Fusion Recipes", "One-pot comfort foods", "East Coast-style meals", "West Coast-style meals"};
    private TextView mCuisineHeadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_list);

//        mCuisineHeadingTextView = (TextView) findViewById(R.id.cuisineHeadingTextView);
//        Typeface headingFont = Typeface.createFromAsset(getAssets(), "fonts/Windsong.ttf");
//        mCuisineHeadingTextView.setTypeface(headingFont);

        mCuisineListView = (ListView) findViewById(R.id.cuisineListView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, cuisines);
        mCuisineListView.setAdapter(adapter);

        mCuisineListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cuisine = cuisines[i];

                Intent intent = new Intent(CuisineListActivity.this, RecipeListActivity.class);
                intent.putExtra("cuisine", cuisine);
                startActivity(intent);
            }
        });



    }


}
