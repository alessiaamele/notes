package com.example.notes.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NotesRepository repo;

    @Autowired
    public NoteService(NotesRepository repo){
        this.repo=repo;
    }
    public List<Note> readAllNotes(){
    return this.repo.findAll();
    }


}
