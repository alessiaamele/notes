package com.example.notes.rest;

import com.example.notes.domain.Note;
import com.example.notes.domain.NoteBook;
import com.example.notes.service.NoteBookService;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class NoteBookController {

    private final NoteBookService noteBookService;

    @Autowired
    public NoteBookController(NoteBookService noteBookService) {

        this.noteBookService = noteBookService;
    }

    // This line will assign an URL which will be triggered by the browser and sets what it will return
    // The ("/") is actually the URL here
    @GetMapping("/getAllNoteBook")
    public List<NoteBook> getAllNoteBook() {
        return this.noteBookService.readAllNoteBook();
    }

    // Create a new URL (/createNote)
    // @RequestBody:
    @PostMapping("/createNoteBook")
    public NoteBook createNoteBook(@RequestBody NoteBook noteBook){
        return this.noteBookService.createNoteBook(noteBook);
    }

    // Delete an URL
    @DeleteMapping("/deleteNoteBook/{id}")
    public Boolean deleteNoteBook(@PathVariable Long id){
        return this.noteBookService.deleteNoteBookById(id);
    }

    // Get specific note by Id
    @GetMapping("/getNoteBookById/{id}")
    public NoteBook getNoteBookById(@PathVariable Long id){
        return this.noteBookService.findNoteBookById(id);
    }

    // Updating
    // @Postmapping is when you create an entirely new note
    // @Putmapping is when it already exists
    @PutMapping("/updateNoteBook/{id}")
    public NoteBook updateNote(@PathVariable Long id, @RequestBody NoteBook noteBook){
        return this.noteBookService.updateNoteBook(id, noteBook);
    }

    //Another way to take in data through the URL
    @PutMapping("/updateNoteBook2")
    public NoteBook updateNoteWithParam(@PathParam("id") Long id, @RequestBody NoteBook noteBook){
        // localhost:8080/updateNoteWithPathParam?id=1
        return this.noteBookService.updateNoteBook(id, noteBook);
    }
}
