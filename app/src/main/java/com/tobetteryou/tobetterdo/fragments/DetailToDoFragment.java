package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

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
        tasarim = FragmentDetailToDoBinding.inflate(inflater, container, false);

        tasarim.toolbarDetailToDo.setTitle("Detail To Do");

        DetailToDoFragmentArgs bundle = DetailToDoFragmentArgs.fromBundle(getArguments());
        Event upcoming_event = bundle.getEvent();

        tasarim.editTextAddToDo.setText(upcoming_event.getEvent_name());

        tasarim.buttonUpdateToDo.setOnClickListener(view -> {
            String event_name = tasarim.editTextAddToDo.getText().toString();
            update(upcoming_event.getEvent_id(),event_name);
        });


        return  tasarim.getRoot();
    }

    public void update(int event_id,String event_name){
        Log.e("Event",event_name);
    }
}