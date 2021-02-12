package com.nedashkovskiy.randomuserviewer.api_pojo.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {
    @SerializedName("thumbnail")
    @Expose
    private String small;

    @SerializedName("large")
    @Expose
    private String large;

    @SerializedName("medium")
    @Expose
    private String medium;


    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }
}
