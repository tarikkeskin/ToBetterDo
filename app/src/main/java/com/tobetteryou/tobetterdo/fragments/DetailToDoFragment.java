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
import com.tobetteryou.tobetterdo.adapter.EventAdapter;
import com.tobetteryou.tobetterdo.databinding.FragmentDetailToDoBinding;
import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.viewmodels.DetailToDoFragmentViewModel;


public class DetailToDoFragment extends Fragment {

    private FragmentDetailToDoBinding tasarim;
    private DetailToDoFragmentViewModel viewModel;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetailToDoFragmentViewModel.class);
    }

    public void buttonUpdate(int event_id, String event_name){
        viewModel.update(event_id,event_name);
    }
}