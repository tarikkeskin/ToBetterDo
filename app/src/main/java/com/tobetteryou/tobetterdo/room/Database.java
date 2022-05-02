package com.tobetteryou.tobetterdo.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tobetteryou.tobetterdo.entity.Event;

@androidx.room.Database(entities = {Event.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract EventsDao eventsDao();
    public static Database INSTANCE;

    public static Database databaseConnection(Context context){
        if(INSTANCE == null){
            synchronized (Database.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        Database.class,"bettertodo.sqlite")
                        .createFromAsset("bettertodo.sqlite")
                        .build();
            }
        }
        return INSTANCE;
    }
}
