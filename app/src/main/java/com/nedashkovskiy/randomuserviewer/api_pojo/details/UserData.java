package com.nedashkovskiy.randomuserviewer.api_pojo.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("name")
    @Expose
    private Name name;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("dob")
    @Expose
    private DateOfBirthday dob;

    @SerializedName("picture")
    @Expose
    private Picture pictures;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private String phone;

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public DateOfBirthday getDob() {
        return dob;
    }

    public Picture getPictures() {
        return pictures;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name=" + name +
                ", dob=" + dob +
                ", pictures=" + pictures +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
