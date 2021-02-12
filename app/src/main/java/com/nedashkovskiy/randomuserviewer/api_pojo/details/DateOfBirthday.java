package com.nedashkovskiy.randomuserviewer.api_pojo.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DateOfBirthday {
    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("age")
    @Expose
    private String age;

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }
}
