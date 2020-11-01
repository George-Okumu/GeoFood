
package com.moringa.geofood.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MealDB {

    @SerializedName("meals")
    @Expose
    private List<Meal> meals = new ArrayList<Meal>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MealDB() {
    }

    /**
     * 
     * @param meals
     */
    public MealDB(List<Meal> meals) {
        super();
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public MealDB withMeals(List<Meal> meals) {
        this.meals = meals;
        return this;
    }

}
