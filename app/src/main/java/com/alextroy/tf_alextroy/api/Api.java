package com.alextroy.tf_alextroy.api;

import com.alextroy.tf_alextroy.model.Currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/latest")
    Call<Currency> loadCurrency(@Query("access_key") String key);
}
