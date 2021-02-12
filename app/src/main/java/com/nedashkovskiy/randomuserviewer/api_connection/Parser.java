package com.nedashkovskiy.randomuserviewer.api_connection;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nedashkovskiy.randomuserviewer.App;
import com.nedashkovskiy.randomuserviewer.api_pojo.Results;
import com.nedashkovskiy.randomuserviewer.api_pojo.details.UserData;
import com.nedashkovskiy.randomuserviewer.data_base.User;
import com.nedashkovskiy.randomuserviewer.data_base.UserRepository;
import com.nedashkovskiy.randomuserviewer.view_model.UserViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Parser {
    private static final String API_URL = "https://randomuser.me/api/?format=json";

    public void startApiConnection(){
        Connection connection = retrofitConnection().create(Connection.class);
        Call<Results> call = connection.getResult(API_URL);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Toast.makeText(App.getContext(), "NEW USER WAS ADDED!", Toast.LENGTH_SHORT).show();
                UserData userData = response.body().getUserData().get(0);
                UserViewModel userViewModel = new UserViewModel(App.getInstance());
                userViewModel.insert(setUser(userData));
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(App.getContext(),"CONNECTION IS FAILED!" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    _______________________________________________

    private Retrofit retrofitConnection(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

//    _______________________________________________

    private User setUser(UserData userData){
        return new User(userData.getName().getTitle(), userData.getName().getFirst(), userData.getName().getLast(),
                userData.getGender(), userData.getEmail(), userData.getPhone(),
                userData.getLocation().getCity(), userData.getLocation().getState(), userData.getLocation().getCountry(),
                userData.getDob().getDate(), userData.getDob().getAge(),
                userData.getPictures().getSmall(), userData.getPictures().getMedium(), userData.getPictures().getLarge());
    }
}