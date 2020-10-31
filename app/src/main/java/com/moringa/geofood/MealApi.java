package com.moringa.geofood;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealApi {
    @GET("random.php")
    Call<MealDB> getRandomMeals(

    );
}
