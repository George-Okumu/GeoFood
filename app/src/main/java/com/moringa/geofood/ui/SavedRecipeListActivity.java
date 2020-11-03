package com.moringa.geofood.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringa.geofood.Constants;
import com.moringa.geofood.R;
import com.moringa.geofood.adapters.FirebaseRecipeViewHolder;
import com.moringa.geofood.model.Meal;

import org.json.JSONException;
import org.json.JSONObject;

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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mRecipeReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPES)
                .child(uid);

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
                String key = getRef(position).getKey();
                mRecipeReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                       String savedData = snapshot.child(key).getValue().toString();
                        try {
                            JSONObject meal = new JSONObject(savedData);
                            String idMeal = meal.getString("idMeal");
                            String pushId = meal.getString("pushId");
                            String strArea = meal.getString("strArea");
                            String strCategory = meal.getString("strCategory");
                            String strIngredient1 = meal.getString("strIngredient1");
                            String strIngredient10 = meal.getString("strIngredient10");
                            String strIngredient11 = meal.getString("strIngredient11");
                            String strIngredient12 = meal.getString("strIngredient12");
                            String strIngredient13 = meal.getString("strIngredient13");
                            String strIngredient14 = meal.getString("strIngredient14");
                            String strIngredient15 = meal.getString("strIngredient15");
                            String strIngredient16 = meal.getString("strIngredient16");
                            String strIngredient17 = meal.getString("strIngredient17");
                            String strIngredient18 = meal.getString("strIngredient18");
                            String strIngredient19 = meal.getString("strIngredient19");
                            String strIngredient2 = meal.getString("strIngredient2");
                            String strIngredient20 = meal.getString("strIngredient20");
                            String strIngredient3 = meal.getString("strIngredient3");
                            String strIngredient4 = meal.getString("strIngredient4");
                            String strIngredient5 = meal.getString("strIngredient5");
                            String strIngredient6 = meal.getString("strIngredient6");
                            String strIngredient7 = meal.getString("strIngredient7");
                            String strIngredient8 = meal.getString("strIngredient8");
                            String strIngredient9 = meal.getString("strIngredient9");
                            String strInstructions = meal.getString("strInstructions");
                            String strMeal = meal.getString("strMeal");
                            String strMealThumb = meal.getString("strMealThumb");
                            String strMeasure1 = meal.getString("strMeasure1");
                            String strMeasure10 = meal.getString("strMeasure10");
                            String strMeasure11 = meal.getString("strMeasure11");
                            String strMeasure12 = meal.getString("strMeasure12");
                            String strMeasure13 = meal.getString("strMeasure13");
                            String strMeasure14 = meal.getString("strMeasure14");
                            String strMeasure15 = meal.getString("strMeasure15");
                            String strMeasure16 = meal.getString("strMeasure16");
                            String strMeasure17 = meal.getString("strMeasure17");
                            String strMeasure18 = meal.getString("strMeasure18");
                            String strMeasure19 = meal.getString("strMeasure19");
                            String strMeasure2 = meal.getString("strMeasure2");
                            String strMeasure20 = meal.getString("strMeasure20");
                            String strMeasure3 = meal.getString("strMeasure3");
                            String strMeasure4 = meal.getString("strMeasure4");
                            String strMeasure5 = meal.getString("strMeasure5");
                            String strMeasure6 = meal.getString("strMeasure6");
                            String strMeasure7 = meal.getString("strMeasure7");
                            String strMeasure8 = meal.getString("strMeasure8");
                            String strMeasure9 = meal.getString("strMeasure9");
                            String strSource = meal.getString("strSource");
                            String strYoutube = meal.getString("strYoutube");






                            Meal newMeal = new Meal(idMeal,pushId, strArea,strCategory, strIngredient1,strIngredient10, strIngredient11,strIngredient12,strIngredient13,strIngredient14, strIngredient15,strIngredient16,strIngredient17,strIngredient18,strIngredient19,
                                    strIngredient2,strIngredient20, strIngredient3, strIngredient4, strIngredient5,strIngredient6, strIngredient7, strIngredient8, strIngredient9, strInstructions,
                                    strMeal, strMealThumb, strMeasure1, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15,
                                    strMeasure16, strMeasure17, strMeasure18, strMeasure19, strMeasure2, strMeasure20, strMeasure3, strMeasure4, strMeasure5,strMeasure6, strMeasure7, strMeasure8, strMeasure9,
                                    strSource, strYoutube);
                            firebaseRestaurantViewHolder.bindRecipe(newMeal);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

            @NonNull
            @Override
            public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_recipe, parent, false);
                Log.d(TAG, "onCreateViewHolder: Error  here");

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
