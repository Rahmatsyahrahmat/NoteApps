package com.rahmatsyah.mynoteapps.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.rahmatsyah.mynoteapps.database.Note;
import com.rahmatsyah.mynoteapps.database.NoteDao;
import com.rahmatsyah.mynoteapps.database.NoteRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private NoteDao noteDao;
    private ExecutorService executorService;
    public NoteRepository(Application application){
        executorService = Executors.newSingleThreadExecutor();

        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        noteDao = db.noteDao();
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteDao.getAllNotes();
    }

    public void insert(final Note note){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(note);
            }
        });
    }

    public void delete(final Note note){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.delete(note);
            }
        });
    }

    public void update(final Note note){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.update(note);
            }
        });
    }

}
