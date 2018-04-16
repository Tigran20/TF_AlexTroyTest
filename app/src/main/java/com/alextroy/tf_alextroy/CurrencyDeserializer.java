package com.alextroy.tf_alextroy;

import com.alextroy.tf_alextroy.model.Currency;
import com.alextroy.tf_alextroy.model.Rates;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class CurrencyDeserializer implements JsonDeserializer<Currency> {
    @Override
    public Currency deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Rates rates = new Rates(
                json.getAsJsonObject().get("rates").getAsJsonObject().get("RUB").getAsFloat(),
                json.getAsJsonObject().get("rates").getAsJsonObject().get("AUD").getAsFloat()
        );

        return new Currency(
                json.getAsJsonObject().get("base").getAsString(),
                json.getAsJsonObject().get("date").getAsString(),
                rates
        );
    }
}
