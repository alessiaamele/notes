// Purpose of Controller: Assign bundles:[URL, info to be displayed coming from Service]

package com.example.notes.rest;

import com.example.notes.domain.Note;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController will create a file in a Json Format
@RestController
public class NotesController {

    private final NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    // This line will assign an URL which will be triggered by the browser and sets what it will return
    @GetMapping("/")
    public List<Note> getAllNotes() {
        return this.noteService.readAllNotes();
    }

}