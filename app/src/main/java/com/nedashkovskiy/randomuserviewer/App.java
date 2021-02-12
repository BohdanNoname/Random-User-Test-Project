package com.nedashkovskiy.randomuserviewer;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.nedashkovskiy.randomuserviewer.data_base.DaoUser;
import com.nedashkovskiy.randomuserviewer.data_base.DataBaseNotification;

public class App extends Application {
    private static Context context;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        instance = this;
    }

    public static Context getContext() {
        return context;
    }
    public static App getInstance(){
        return instance;
    }
}
