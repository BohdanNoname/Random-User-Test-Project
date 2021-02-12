package com.nedashkovskiy.randomuserviewer.data_base;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private DaoUser daoUser;
    private LiveData<List<User>> allUsers;

    public UserRepository (Application application){
        DataBaseNotification dataBaseNotification = DataBaseNotification.getInstance(application);
        daoUser = dataBaseNotification.daoUser();
        allUsers = daoUser.selectAll();
    }

    public void  insert(User user){
        new UserRepositoryAsyncTask(daoUser, "insert").execute(user);
    }

    public void  update(User user){
        new UserRepositoryAsyncTask(daoUser, "update").execute(user);
    }

    public void  delete(User user){
        new UserRepositoryAsyncTask(daoUser, "delete").execute(user);
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

//    _______________________________________________

    private static class UserRepositoryAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser daoUser;
        private String query;

        private UserRepositoryAsyncTask(DaoUser daoUser, String query){
            this.daoUser = daoUser;
            this.query = query;
        }

        @Override
        protected Void doInBackground(User... users) {
            switch (query){
                case "insert":
                    daoUser.insert(users[0]);
                    break;
                case "update":
                    daoUser.update(users[0]);
                    break;
                case "delete":
                    daoUser.delete(users[0]);
                    break;
            }
            return null;
        }
    }
}
