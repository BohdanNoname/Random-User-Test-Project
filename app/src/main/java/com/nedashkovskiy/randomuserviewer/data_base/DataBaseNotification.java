package com.nedashkovskiy.randomuserviewer.data_base;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =  {User.class}, version = 3, exportSchema = false)
public abstract class DataBaseNotification  extends RoomDatabase {
    private static final String DATA_BASE_NAME = "RANDOM_USER_DB_1";

    private static DataBaseNotification instance;
    public abstract DaoUser daoUser();

    public static synchronized DataBaseNotification getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DataBaseNotification.class, DataBaseNotification.DATA_BASE_NAME)
                    .fallbackToDestructiveMigration().build();
            return instance;
        }
        return instance;
    }
}