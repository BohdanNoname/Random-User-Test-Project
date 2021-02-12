package com.nedashkovskiy.randomuserviewer.ui.recycler_view;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nedashkovskiy.randomuserviewer.App;
import com.nedashkovskiy.randomuserviewer.R;
import com.nedashkovskiy.randomuserviewer.data_base.User;
import com.nedashkovskiy.randomuserviewer.ui.activities.MainActivity;
import com.nedashkovskiy.randomuserviewer.ui.fragments.ProfileDataFragment;
import com.nedashkovskiy.randomuserviewer.view_model.UserViewModel;

import java.util.List;

public class UserListRecyclerAdapter extends RecyclerView.Adapter<UserListRecyclerAdapter.AdapterViewHolder> {

    private List<User> listUsers;

    public UserListRecyclerAdapter(List<User> listUsers){
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_layout_recycler_view_user_list, parent, false);
        return new AdapterViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.userID.setText(String.valueOf(position+1));
        holder.name.setText(listUsers.get(position).getFirst());
        holder.surname.setText(listUsers.get(position).getLast());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.getContext(), "USER WAS DELETED!", Toast.LENGTH_SHORT).show();
                UserViewModel viewModel = new UserViewModel(App.getInstance());
                viewModel.delete(listUsers.get(position));
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ProfileDataFragment(listUsers.get(position));
                FragmentTransaction transaction = MainActivity.getActivity().getFragmentManager().beginTransaction().addToBackStack("BackStackFragment");
                transaction.replace(R.id.users_data_fragment, fragment, "fragment").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

//    _______________________________________________

    protected class AdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView userID, name, surname;
        private ImageView delete;
        private LinearLayout layout;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            userID = itemView.findViewById(R.id.user_id);
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);
            delete = itemView.findViewById(R.id.delete);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
