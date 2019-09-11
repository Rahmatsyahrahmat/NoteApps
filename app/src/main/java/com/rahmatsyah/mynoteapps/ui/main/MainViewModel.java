package com.rahmatsyah.mynoteapps.ui.main;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rahmatsyah.mynoteapps.database.Note;
import com.rahmatsyah.mynoteapps.repository.NoteRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private NoteRepository noteRepository;

    public MainViewModel(Application application){
        noteRepository = new NoteRepository(application);
    }

    LiveData<List<Note>> getAllNotes(){
        return noteRepository.getAllNotes();
    }

}
