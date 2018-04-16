package com.alextroy.tf_alextroy.api;

import android.app.Application;

import com.alextroy.tf_alextroy.CurrencyDeserializer;
import com.alextroy.tf_alextroy.model.Currency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static final String BASE_URL = "http://data.fixer.io/";

    private static Api api;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Currency> deserializer = new CurrencyDeserializer();
        gsonBuilder.registerTypeAdapter(Currency.class, deserializer);
        Gson gson = gsonBuilder.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(Api.class);
    }

    public static Api getApi() {
        return api;
    }
}
