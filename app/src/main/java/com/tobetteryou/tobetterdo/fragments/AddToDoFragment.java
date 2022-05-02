package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tobetteryou.tobetterdo.R;
import com.tobetteryou.tobetterdo.databinding.FragmentAddToDoBinding;
import com.tobetteryou.tobetterdo.viewmodels.AddToDoFragmentViewModel;


public class AddToDoFragment extends Fragment {

    private FragmentAddToDoBinding tasarim;
    private AddToDoFragmentViewModel viewModel;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AddToDoFragmentViewModel.class);
    }
    public void buttonAdd(String event_name){
        viewModel.add(event_name);
    }

}