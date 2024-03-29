package com.rahmatsyah.mynoteapps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.rahmatsyah.mynoteapps.ui.insert.NoteAddUpdateActivity;
import com.rahmatsyah.mynoteapps.ui.insert.NoteAddUpdateViewModel;
import com.rahmatsyah.mynoteapps.ui.main.MainViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final Application application;

    private ViewModelFactory(Application application){
        this.application = application;
    }

    public static ViewModelFactory getInstance(Application application){
        if (INSTANCE==null){
            synchronized (ViewModelFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new ViewModelFactory(application);
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel(application);
        }else if (modelClass.isAssignableFrom(NoteAddUpdateViewModel.class)){
            return (T) new NoteAddUpdateViewModel(application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: "+modelClass.getName());
    }
}
