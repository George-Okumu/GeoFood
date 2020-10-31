package com.moringa.geofood.network;

import com.moringa.geofood.Constants;
import com.moringa.geofood.network.MealApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealClient {
    private static Retrofit retrofit = null;

    public static MealApi getClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        if(retrofit == null){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            okHttpClient.addInterceptor(httpLoggingInterceptor);
            okHttpClient.build();
        }
        retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.MEALDB_BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MealApi.class);
    }
}
