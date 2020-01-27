package com.learnandroid.retrofitclient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Requester {

    private static Requester instance;
    private ContactsAPI contactsAPI;

    private Requester() {}

    public static Requester getInstance() {
        if (instance==null) {
            instance = new Requester();
        }
        return instance;
    }


    public void connect() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://157.245.228.132:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        contactsAPI = retrofit.create(ContactsAPI.class);
    }

    public ContactItem getContactItem() {
        Call<ContactItem> repos = contactsAPI.getContactItem();

        Response<ContactItem> response = null;
        try {
            response = repos.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.body();

    }

}
