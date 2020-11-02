package com.moringa.geofood.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.geofood.Constants;
import com.moringa.geofood.R;
import com.moringa.geofood.adapters.FirebaseRecipeViewHolder;
import com.moringa.geofood.adapters.savedAdapter;
import com.moringa.geofood.model.Meal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRecipeListActivity extends AppCompatActivity {
    private static final String TAG = " ";


    private DatabaseReference mRecipeReference;
    private FirebaseRecyclerAdapter<Meal, FirebaseRecipeViewHolder> mFirebaseAdapter;

    @BindView(R.id.savedRecycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipe);
        ButterKnife.bind(this);

        mRecipeReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Meal> options =
                new FirebaseRecyclerOptions.Builder<Meal>()
                        .setQuery(mRecipeReference, Meal.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Meal, FirebaseRecipeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder firebaseRestaurantViewHolder, int position, @NonNull Meal meals) {
                firebaseRestaurantViewHolder.bindRecipe(meals);
            }

            @NonNull
            @Override
            public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_recipe, parent, false);
                Log.d(TAG, "onCreateViewHolder: Error Biiiiiiiiiiig one");

                return new FirebaseRecipeViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mFirebaseAdapter != null) {
            mFirebaseAdapter.stopListening();
        }


//    private RecyclerView recyclerView;
//    savedAdapter adapter;
//    DatabaseReference mDatabase;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved_recipe);
//
//        ButterKnife.bind(this);
//
//        mDatabase = FirebaseDatabase
//                .getInstance()
//                .getReference();
//        recyclerView = findViewById(R.id.savedRecycler);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        FirebaseRecyclerOptions<Meal> options = new FirebaseRecyclerOptions.Builder<Meal>()
//                .setQuery(mDatabase, Meal.class)
//                .build();
//
//
//        // Connecting object of required Adapter class to
//        // the Adapter class itself
//        adapter = new savedAdapter(options);
//
//
//        // Connecting Adapter class with the Recycler view*/
//        recyclerView.setAdapter(adapter);
//
//    }
//
//    // Function to tell the app to start getting
//    // data from database on starting of the activity
//    @Override protected void onStart()
//    {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    // Function to tell the app to stop getting
//    // data from database on stoping of the activity
//    @Override protected void onStop()
//    {
//        super.onStop();
//        adapter.stopListening();
//    }

    }
}
