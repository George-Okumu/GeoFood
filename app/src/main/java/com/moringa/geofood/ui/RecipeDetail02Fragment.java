package com.moringa.geofood.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.geofood.Constants;
import com.moringa.geofood.R;
import com.moringa.geofood.model.Meal;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetail02Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetail02Fragment extends Fragment implements  View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 @BindView(R.id.recipeImageView) ImageView  mRecipeImageView;
 @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
 @BindView(R.id.categoryTextView) TextView mCategoryTextView;
 @BindView(R.id.youtubeLink) TextView mYoutubeLink;
 @BindView(R.id.instructionsTextView) TextView mInstructionsTextView;
 @BindView(R.id.savedRecipeButton) Button mSavedRecipeButton;


    // TODO: Rename and change types of parameters
    private Meal mStrMeal;

    public RecipeDetail02Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeDetail02Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeDetail02Fragment newInstance(Meal meals) {
        RecipeDetail02Fragment fragment = new RecipeDetail02Fragment();
        Bundle args = new Bundle();
        args.putParcelable("meals", Parcels.wrap(meals));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStrMeal = Parcels.unwrap(getArguments().getParcelable("meals"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_detail02, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mStrMeal.getStrMealThumb()).into(mRecipeImageView);
        mRecipeNameTextView.setText(mStrMeal.getStrMeal());
        mCategoryTextView.setText(mStrMeal.getStrCategory());
        mYoutubeLink.setText(mStrMeal.getStrYoutube());
        mInstructionsTextView.setText(mStrMeal.getStrInstructions());

        mYoutubeLink.setOnClickListener(this);
        mSavedRecipeButton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {

        if(v == mSavedRecipeButton){
            FirebaseUser user = FirebaseAuth
                    .getInstance()
                    .getCurrentUser();
            String uid = user.getUid();


            DatabaseReference recipeRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_RECIPES)
                    .child(uid);

            DatabaseReference pushRef = recipeRef.push();
            String savedId = pushRef.getKey();//Collecting pushId and assgining new variable
            mStrMeal.setPushId(savedId);
            pushRef.setValue(mStrMeal);//Setting the value to the save recipe value in a specified node


            Toast.makeText(getContext(), "Saved successfully", Toast.LENGTH_SHORT).show();
        }
        if(v == mYoutubeLink){
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mStrMeal.getStrYoutube()));
            startActivity(youtubeIntent);

        }
    }
}