package com.example.notes.service;

import com.example.notes.repo.NotesRepository;
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
    public Note createNote(Note note){
    return this.repo.save(note);
    }
    public Note findNoteById(Long id){
    return this.repo.findById(id).orElseThrow(  );

















}