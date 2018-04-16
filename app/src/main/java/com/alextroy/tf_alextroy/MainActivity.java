package com.alextroy.tf_alextroy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.alextroy.tf_alextroy.api.App;
import com.alextroy.tf_alextroy.model.Currency;
import com.alextroy.tf_alextroy.model.Rates;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "a449de2a9b582986de1c3ee42bb6eb7f";

    private TextView baseCurrency;
    private TextView dateCurrency;
    private TextView dateRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseCurrency = findViewById(R.id.currency_base);
        dateCurrency = findViewById(R.id.currency_date);
        dateRate = findViewById(R.id.currency_rate);

        getCurrency();
    }

    public void getCurrency() {
        App.getApi().loadCurrency(KEY).enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                baseCurrency.setText(response.body().getBase());

//                String text = "Курс валюты к Евро: ";
//                dateCurrency.setText(text + response.body().getRates().getEUR().toString());
//
                String date = "Текущая дата: ";
                dateRate.setText(date + response.body().getDate());

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
