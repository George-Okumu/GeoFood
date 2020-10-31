package com.moringa.geofood.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringa.geofood.model.Meal;
import com.moringa.geofood.ui.RecipeDetail02Fragment;

import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private List<Meal> mMeals;


    public RecipePagerAdapter(FragmentManager fm, int behavior, List<Meal> meals){
        super(fm, behavior);
        mMeals = meals;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return RecipeDetail02Fragment.newInstance(mMeals.get(position));
    }

    @Override
    public int getCount() {
        return mMeals.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mMeals.get(position).getStrMeal();
    }
}
