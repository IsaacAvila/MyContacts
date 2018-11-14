package com.example.hobo.mycontacts.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.hobo.mycontacts.fragment.IFragmentRecyclerViewView;
import com.example.hobo.mycontacts.pojo.Contact;
import com.example.hobo.mycontacts.restApi.Endpoints;
import com.example.hobo.mycontacts.restApi.adapter.RestApiAdapter;
import com.example.hobo.mycontacts.restApi.model.ContactResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Caleb on 7/17/2017.
 */

public class FragmentRecycleViewPresenter implements IFragmentRecyclerViewPresenter {

    private IFragmentRecyclerViewView iFragmentRecyclerViewView;
    private Context context;
    private ArrayList<Contact> contacts;

    public FragmentRecycleViewPresenter(IFragmentRecyclerViewView iFragmentRecyclerView, Context context) {
        this.iFragmentRecyclerViewView = iFragmentRecyclerView;
        this.context = context;
        getRecentMedia();
    }

    @Override
    public void getRecentMedia() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.buidGsonDeserializerMediaRecent();
        Endpoints endpoints = restApiAdapter.setInstaRestApiConection(gson);
        Call<ContactResponse> contactResponseCall = endpoints.getRecentMedia();

        contactResponseCall.enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                ContactResponse contactResponse = response.body();
                contacts = contactResponse.getContacts();
                showContacts();
            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {
                Toast.makeText(context, "Somthing is wrong", Toast.LENGTH_SHORT).show();
                Log.e("Conection failed ", t.toString());
            }
        });
    }

    @Override
    public void showContacts() {
        iFragmentRecyclerViewView.startAdapter(iFragmentRecyclerViewView.createAdapter(contacts));
        iFragmentRecyclerViewView.generateGridLayout();
    }
}
