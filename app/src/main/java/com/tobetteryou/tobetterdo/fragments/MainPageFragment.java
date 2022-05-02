package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tobetteryou.tobetterdo.R;
import com.tobetteryou.tobetterdo.adapter.EventAdapter;
import com.tobetteryou.tobetterdo.databinding.FragmentMainPageBinding;
import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.viewmodels.MainPageFragmentViewModel;

import java.util.ArrayList;
import java.util.Vector;

public class MainPageFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentMainPageBinding tasarim;
    private MainPageFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //DataBinding
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page,container, false);
        //Authorization of layout object
        tasarim.setMainPageFragmentObject(this);

        tasarim.setMainPageToolbarName("To Do List");

        //support out toolbar as action bar
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarMainPage);

        viewModel.eventList.observe(getViewLifecycleOwner(),liste->{
            EventAdapter eventAdapter = new EventAdapter(requireContext(),liste,viewModel);
            tasarim.setEventAdapter(eventAdapter);
        });

        return tasarim.getRoot();
    }

    public void fabClick(View view){
        Navigation.findNavController(view).navigate(R.id.addToDoNavigation);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        viewModel = new ViewModelProvider(this).get(MainPageFragmentViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.search(newText);
        return true;
    }

}