package com.moringa.geofood.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringa.geofood.Constants;
import com.moringa.geofood.R;
import com.moringa.geofood.adapters.RecipePagerAdapter;
import com.moringa.geofood.model.Meal;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetail02Activity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private RecipePagerAdapter adapterViewPage;
    List<Meal> mMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail02);
        ButterKnife.bind(this);

        mMeals = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_KEY_RECIPES));
        int startingPosition = getIntent()  .getIntExtra(Constants.EXTRA_KEY_POSITION, 0);

        adapterViewPage = new RecipePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mMeals);
        mViewPager.setAdapter(adapterViewPage);
        mViewPager.setCurrentItem(startingPosition);
    }

}