package com.nedashkovskiy.randomuserviewer.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.nedashkovskiy.randomuserviewer.R;
import com.nedashkovskiy.randomuserviewer.data_base.User;
import com.squareup.picasso.Picasso;


public class ProfileDataFragment extends Fragment {
    private User user;

    private ImageView imageView;
    private TextView name, surname, gender, email, phone, city, state, country, date, age;
    private View root, borderLine;


    public ProfileDataFragment(){}

    @SuppressLint("ValidFragment")
    public ProfileDataFragment(User user){
        this.user = user;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profile_data, container,false);
        if (user!=null){
            userDataRealization(root, user);
        }
        return root;
    }

//    _______________________________________________

    private void userDataRealization(View root, User user){
        imageView = root.findViewById(R.id.fragment_profile_image);
        name = root.findViewById(R.id.full_name);
        surname = root.findViewById(R.id.surname);
        gender = root.findViewById(R.id.gender);
        email = root.findViewById(R.id.email);
        phone = root.findViewById(R.id.phone) ;
        city = root.findViewById(R.id.city);
        state = root.findViewById(R.id.state);
        country = root.findViewById(R.id.country);
        date = root.findViewById(R.id.date_of_birth);
        age = root.findViewById(R.id.age);
        borderLine = root.findViewById(R.id.border_line);
        setDataToViews(user);
    }

    private void setDataToViews(User user){
        Picasso.get().load(user.getPictureLarge()).into(imageView);

        name.setText(user.getTitle() + ". " + user.getFirst());
        surname.setText(user.getLast());
        gender.setText(user.getGender());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        city.setText(user.getCity());
        state .setText(user.getState());
        country.setText(user.getCountry());
        date.setText(user.getDate());
        age.setText(user.getAge());

        borderLine.setAlpha(1f);
    }

}
