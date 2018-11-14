package com.example.hobo.mycontacts.restApi.adapter;

import com.example.hobo.mycontacts.restApi.Constants;
import com.example.hobo.mycontacts.restApi.Endpoints;
import com.example.hobo.mycontacts.restApi.deserializer.ContactDeserializer;
import com.example.hobo.mycontacts.restApi.model.ContactResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Caleb on 7/20/2017.
 */

public class RestApiAdapter {

    public Endpoints setInstaRestApiConection(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(Endpoints.class);
    }

    public Gson buidGsonDeserializerMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactResponse.class, new ContactDeserializer());
        return gsonBuilder.create();

    }
}
