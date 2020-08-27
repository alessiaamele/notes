package com.example.notes.exceptions.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {

    private final NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService){
        this.noteSerice = noteService;
    }

    localhost:8080/
    @GetMapping("/")
    public List<Note> getAllNotes(){
        return this.noteServce.readAllNotes();
    }
}
