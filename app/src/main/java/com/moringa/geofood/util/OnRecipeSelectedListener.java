package com.moringa.geofood.util;

import com.moringa.geofood.model.Meal;

import java.util.ArrayList;

public interface OnRecipeSelectedListener {
    public void onRecipeSelected(Integer position, ArrayList<Meal> meals, String source);

}
