package com.moringa.geofood.network;

import com.moringa.geofood.model.MealDB;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealApi {
    @GET("random.php")
    Call<MealDB> getRandomMeals(

    );
}
