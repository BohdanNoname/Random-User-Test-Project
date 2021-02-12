package com.nedashkovskiy.randomuserviewer.api_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nedashkovskiy.randomuserviewer.api_pojo.details.UserData;

import java.util.List;

public class Results {
    @SerializedName("results")
    @Expose
    private List<UserData> userData;

    public List<UserData> getUserData() {
        return userData;
    }
}
