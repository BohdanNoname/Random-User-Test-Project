package com.nedashkovskiy.randomuserviewer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.nedashkovskiy.randomuserviewer.App;
import com.nedashkovskiy.randomuserviewer.R;
import com.nedashkovskiy.randomuserviewer.data_base.User;
import com.nedashkovskiy.randomuserviewer.ui.recycler_view.LinearLayoutRecyclerView;
import com.nedashkovskiy.randomuserviewer.ui.recycler_view.UserListRecyclerAdapter;
import com.nedashkovskiy.randomuserviewer.view_model.UserViewModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsersListFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_users_list, container, false);
        recyclerView = root.findViewById(R.id.users_list_fragment_recycler_view);
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserViewModel viewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
        viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                recyclerViewRealization(recyclerView, users);
                recyclerView.smoothScrollToPosition(0);
            }
        });
    }
//    _______________________________________________

    private void recyclerViewRealization(RecyclerView recyclerView, List<User> users){
        recyclerView.setLayoutManager(new LinearLayoutRecyclerView(App.getContext()));
        recyclerView.setAdapter(new UserListRecyclerAdapter(getSortedList(users)));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    private List<User> getSortedList(List<User> users){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getId() > o2.getId()){
                    return -1;
                } else return 1;
            }
        });
        return users;
    }
}