package com.tobetteryou.tobetterdo.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//View Model Factory
public class MainPageVMF extends ViewModelProvider.NewInstanceFactory {
    private final Application application;

    public MainPageVMF(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainPageFragmentViewModel(application);
    }
}
