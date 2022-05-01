package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tobetteryou.tobetterdo.R;
import com.tobetteryou.tobetterdo.adapter.EventAdapter;
import com.tobetteryou.tobetterdo.databinding.FragmentDetailToDoBinding;
import com.tobetteryou.tobetterdo.entity.Event;


public class DetailToDoFragment extends Fragment {

    private FragmentDetailToDoBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //DataBinding
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_to_do, container, false);
        //Authorization of layout object
        tasarim.setDetailToDoFragmentObject(this);

        //Toolbar name
        tasarim.setDetailToDoToolbarName("Detail To Doo");

        //Get event object from MainPage fragment and Set it to the updomingEvent variable in layout
        DetailToDoFragmentArgs bundle = DetailToDoFragmentArgs.fromBundle(getArguments());
        Event upcoming_event = bundle.getEvent();
        tasarim.setUpcomingEvent(upcoming_event);


        return  tasarim.getRoot();
    }

    public void update(int event_id,String event_name){
        Log.e("Event",event_name);
    }
}