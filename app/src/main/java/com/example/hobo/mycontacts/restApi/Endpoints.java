package com.example.hobo.mycontacts.restApi;


import com.example.hobo.mycontacts.restApi.model.ContactResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Caleb on 7/20/2017.
 */

public interface Endpoints {

    @GET(Constants.URL_GET_RECENT_USER_MEDIA)
    Call<ContactResponse> getRecentMedia();
}
