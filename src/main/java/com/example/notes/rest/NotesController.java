// Purpose of Controller: Assign bundles:[URL, info to be displayed coming from Service]

package com.example.notes.rest;

import com.example.notes.domain.Note;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    // The ("/") is actually the URL here
    @GetMapping("/")
    public List<Note> getAllNotes() {
        return this.noteService.readAllNotes();
    }

    // Create a new URL (/createNote)
    // @RequestBody:
    @PostMapping("/createNote")
    public Note createNote(@RequestBody Note note){
    return this.noteService.createNote(note);
    }

    // Delete an URL
    @DeleteMapping("/delete/{id}")
    public Boolean deleteNote(@PathVariable Long id){
        return this.noteService.deleteNoteById(id);
    }

    // Get specific note by Id
    @GetMapping("/getNoteById/{id}")
    public Note getNoteById(@PathVariable Long id){
        return this.noteService.findNoteById(id);
    }

    // Updating
    // @Postmapping is when you create an entirely new note
    // @Putmapping is when it already exists
    @PutMapping("/updateNote/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note){
        return this.noteService.updateNote(id, note);
    }

    //Another way to take in data through the URL
    @PutMapping("/updateNote2")
    public Note updateNoteWithParam(@PathParam("id") Long id, @RequestBody Note note){
        // localhost:8080/updateNoteWithPathParam?id=1
        return this.noteService.updateNote(id, note);
    }

}