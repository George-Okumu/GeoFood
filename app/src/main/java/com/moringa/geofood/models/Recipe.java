package com.moringa.geofood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

//    private String uri;
//
//    private String label;
//    private String image;
//    private String source;
//    private String url;
//    private String shareAs;
//    private String yield;
//    private List<Object> dietLabels = new ArrayList<>();
//    private List<String> healthLabels = new ArrayList<>();
//    private List<String> cautions = new ArrayList<>();
//    private List<String> ingredientLines = new ArrayList<>();
//    private List<String> ingredients = new ArrayList<>();
//    private String calories;
//    private Double totalWeight;
//
//    private String pushId;
//    private String index;
//
//    //Empty constructor for serialisation
//    public Recipe(){
//
//    }
//
//    public Recipe(String label, String image, String url, Double yield, ArrayList<String> ingredientLines, Double calories) {
//        this.label = label;
//        this.image = image;
//        this.url = url;
//        this.yield = yield;
//        this.ingredientLines = ingredientLines;
//        this.calories = calories;
//    }
    private String title;
    private String image;
    private String url;
    private List<String> ingredientLines = new ArrayList<>();
    private String calories;
    private String servings;
    private String cuisine;
    private String pushId;
    private String index;


    //Default Constructor
    public Recipe(){}

    public Recipe(String title, String image, String url, ArrayList<String> ingredientLines, String calories, String servings) {
        this.title = title;
        this.image = image;
        this.url = url;
        this.ingredientLines = ingredientLines;
        this.calories = calories;
        this.servings = servings;
        this.index = "not_specified";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
