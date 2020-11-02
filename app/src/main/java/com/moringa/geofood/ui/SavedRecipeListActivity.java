package com.moringa.geofood.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.geofood.Constants;
import com.moringa.geofood.R;
import com.moringa.geofood.adapters.FirebaseRecipeViewHolder;
import com.moringa.geofood.model.Meal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRecipeListActivity extends AppCompatActivity {
    private DatabaseReference mRecipeReference;
    private FirebaseRecyclerAdapter<Meal, FirebaseRecipeViewHolder> mFirebaseAdapter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        ButterKnife.bind(this);

        mRecipeReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPESFOUND);
        setUpFireBaseAdapter();
    }

    public void setUpFireBaseAdapter(){
        FirebaseRecyclerOptions<Meal> options = new FirebaseRecyclerOptions.Builder<Meal>()
                .setQuery(mRecipeReference, Meal.class)
                .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Meal, FirebaseRecipeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder holder, int position, @NonNull Meal model) {

            }

            @NonNull
            @Override
            public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
    }
}