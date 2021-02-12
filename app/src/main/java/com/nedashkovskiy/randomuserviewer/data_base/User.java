package com.nedashkovskiy.randomuserviewer.data_base;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true) int id;
    String title;
    String first;
    String last;
    String gender;

    String email;
    String phone;

    String city;
    String state;
    String country;

    String date;
    String age;

    String pictureSmall;
    String pictureMedium;
    String pictureLarge;

    public User(String title, String first, String last, String gender,
                String email, String phone, String city, String state,
                String country, String date, String age, String pictureSmall,
                String pictureMedium, String pictureLarge) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.country = country;
        this.date = date;
        this.age = age;
        this.pictureSmall = pictureSmall;
        this.pictureMedium = pictureMedium;
        this.pictureLarge = pictureLarge;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
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

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }

    public String getPictureSmall() {
        return pictureSmall;
    }

    public String getPictureMedium() {
        return pictureMedium;
    }

    public String getPictureLarge() {
        return pictureLarge;
    }
}
