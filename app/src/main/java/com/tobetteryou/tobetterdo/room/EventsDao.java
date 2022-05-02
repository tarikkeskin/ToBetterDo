package com.tobetteryou.tobetterdo.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.tobetteryou.tobetterdo.entity.Event;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface EventsDao {
    @Query("select * from events")
    Single<List<Event>> allEvents();
}
