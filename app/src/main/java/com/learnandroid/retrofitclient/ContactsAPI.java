package com.learnandroid.retrofitclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsAPI {
    @GET("/contactitem")
    Call<ContactItem> getContactItem();
    @GET("/contactslist")
    Call<List<ContactItem>> getContactsList();
}
