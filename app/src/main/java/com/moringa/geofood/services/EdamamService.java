package com.moringa.geofood.services;

import com.moringa.geofood.Constants;
import com.moringa.geofood.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EdamamService {

    public void findRecipes(String query, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.EDAMAM_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.EDAMAM_QUERY_PARAMETER, query);
        urlBuilder.addQueryParameter("from", "0");
        urlBuilder.addQueryParameter("to","30");
        urlBuilder.addQueryParameter("app_id", Constants.EDAMAM_ID);
        urlBuilder.addQueryParameter("app_key", Constants.EDAMAM_KEY);
        String url = urlBuilder.build().toString();
        System.out.println(url);


        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    //Creating a new Recipe Array to contain all Recipe properties

    public static ArrayList<Recipe> processResults(Response response){
        ArrayList<Recipe> allRecipes = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject recipeGeoJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = recipeGeoJSON.getJSONArray("hits");

                for(int i = 0; i <recipesJSON.length(); i++){
                    //Getting specific hit
                    JSONObject recipeJSON = recipesJSON.getJSONObject(i);

                    JSONObject newRecipe = recipeJSON.getJSONObject("recipe");

                    String title = newRecipe.getString("label");
                    String image = newRecipe.getString("image");
                    String url = newRecipe.getString("url");
                    String calories = Integer.toString(newRecipe.getInt("calories"));
                    String servings = Integer.toString(newRecipe.getInt("yield"));


                    //Looking for the array of ingredients and adding them to the array
                    ArrayList<String> ingredients = new ArrayList<>();
                    JSONArray ingredientList = newRecipe.getJSONArray("ingredientLines");
                    for(int r = 0; r < ingredientList.length(); i++){
                        ingredients.add(ingredientList.get(r).toString());
                    }

                    System.out.println(ingredients + "ingredients");//Testing if new array of ingredients is formed
                    Recipe recipe = new Recipe(title,image,url,ingredients,calories,servings);
                    allRecipes.add(recipe);


                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
        return allRecipes;
    }
}
