package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
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
        //Data binding
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_add_to_do,container,false);
        //Authorization fragment object to call methods
        tasarim.setAddToDoFragmentObject(this);

        // set toolbar name with data binding
        tasarim.setAddToDoToolbarName("Add To Do");

        return tasarim.getRoot();
    }

    public void add(String event_name){
        Log.e("Event",event_name);
    }

}