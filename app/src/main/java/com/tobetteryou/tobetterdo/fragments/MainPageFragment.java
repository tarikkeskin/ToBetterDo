package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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

import java.util.ArrayList;
import java.util.Vector;

public class MainPageFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentMainPageBinding tasarim;

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


        ArrayList<Event> events = new ArrayList<>();
        Event e1 = new Event(1,"Brush teeth");
        Event e2 = new Event(2,"Develop Project");
        Event e3 = new Event(3,"Go Walk");
        events.add(e1);
        events.add(e2);
        events.add(e3);

        EventAdapter eventAdapter = new EventAdapter(requireContext(),events);
        tasarim.setEventAdapter(eventAdapter);


        return tasarim.getRoot();
    }

    public void fabClick(View view){
        Navigation.findNavController(view).navigate(R.id.addToDoNavigation);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
        search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        search(newText);
        return true;
    }

    public void search(String searchText){
        Log.e("Event",searchText);
    }
}