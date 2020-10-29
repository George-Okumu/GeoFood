package com.moringa.geofood.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class RecipeListAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipe;

    public RecipeListAdapter(@NonNull Context mContext, int resource, String[] mRecipe) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipe = mRecipe;
    }

    @Override
    public Object getItem(int position) {
        String geofood = mRecipe[position];
        return String.format("%s \nHere is the list of:", geofood);
    }

    @Override
    public int getCount() {
        return mRecipe.length;
    }
}
