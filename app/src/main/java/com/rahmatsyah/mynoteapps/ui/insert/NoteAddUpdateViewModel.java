package com.rahmatsyah.mynoteapps.ui.insert;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.rahmatsyah.mynoteapps.database.Note;
import com.rahmatsyah.mynoteapps.repository.NoteRepository;

public class NoteAddUpdateViewModel extends ViewModel {

    private NoteRepository noteRepository;

    public NoteAddUpdateViewModel(Application application){
        noteRepository = new NoteRepository(application);
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }

    public void update(Note note){
        noteRepository.update(note);
    }

    public void delete(Note note){
        noteRepository.delete(note);
    }

}
