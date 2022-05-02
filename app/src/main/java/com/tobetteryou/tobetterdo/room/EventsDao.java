package com.tobetteryou.tobetterdo.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tobetteryou.tobetterdo.entity.Event;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface EventsDao {
    @Query("select * from events")
    Single<List<Event>> allEvents();

    @Insert
    Completable insertEvent(Event event);

    @Update
    Completable updateEvent(Event event);

    @Delete
    Completable deleteEvent(Event event);

    @Query("select * from events where event_ad like '%' || :searchWord || '%' ")
    Single<List<Event>> searchEvent(String searchWord);
}
