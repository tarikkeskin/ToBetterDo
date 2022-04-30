package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tobetteryou.tobetterdo.R;
import com.tobetteryou.tobetterdo.databinding.FragmentAddToDoBinding;


public class AddToDoFragment extends Fragment {

    private FragmentAddToDoBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tasarim = FragmentAddToDoBinding.inflate(inflater, container, false);

        tasarim.toolbarAddToDo.setTitle("Add Event");

        tasarim.buttonAdd.setOnClickListener(view -> {
            String event_name = tasarim.editTextAddToDo.getText().toString();
            add(event_name);
        });

        return tasarim.getRoot();
    }

    public void add(String event_name){
        Log.e("Event",event_name);
    }

}