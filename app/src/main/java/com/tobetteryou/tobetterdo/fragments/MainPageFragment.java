package com.tobetteryou.tobetterdo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tobetteryou.tobetterdo.R;
import com.tobetteryou.tobetterdo.databinding.FragmentMainPageBinding;

public class MainPageFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentMainPageBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tasarim = FragmentMainPageBinding.inflate(inflater, container, false);

        tasarim.toolbarMainPage.setTitle("To Do List");

        //support out toolbar as action bar
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarMainPage);

        tasarim.fab.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.addToDoNavigation);
        });



        return tasarim.getRoot();
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