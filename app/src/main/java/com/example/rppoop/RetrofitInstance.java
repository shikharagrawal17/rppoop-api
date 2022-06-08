package com.example.rppoop;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://6d4f-2409-4042-4e1e-c6d8-e5d8-f805-c7ef-8a29.in.ngrok.io/";

    public static QuestionDataService getService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(QuestionDataService.class);
    }
}
