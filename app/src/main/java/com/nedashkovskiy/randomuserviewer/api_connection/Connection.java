package com.nedashkovskiy.randomuserviewer.api_connection;

import com.nedashkovskiy.randomuserviewer.api_pojo.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface Connection {
    @GET
    Call<Results> getResult(@Url String url);
}
