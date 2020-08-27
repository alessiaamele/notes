package com.example.notes.service;

import com.example.notes.domain.Note;
import com.example.notes.exceptions.NoteNotFoundException;
import com.example.notes.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// The Service class will have most of the business logic (most of what we want the application to do)
@Service
public class NoteService {

    // Need to interact with repository: create a class field for it
    private final NotesRepository repo;

    // Use a constructor + @Autowired to do this rapidly
    @Autowired
    public NoteService(NotesRepository repo) {
        this.repo = repo;
    }

    // Functionality 1: get all notes from database so they can be displayed. The app already runs with only this field (doesn't do much but still)
    public List<Note> readAllNotes(){
        return this.repo.findAll();
    }

    // Functionality 2: Create Notes
    public Note createNote(Note note){
        return this.repo.save(note);
    }

    // Functionality 3: Find Notes by Id <- returns an optional in case Id Not found, and here we generate the
    // NoteNotFoundException class in parallel which will display the message of our choice
    public Note findNoteById(Long id){
        return this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
    }

    public Note updateNote(Long id, Note note){
        Note update = findNoteById(id);
        update.setTitle(note.getTitle());
        update.setDescription(note.getDescription());
        return this.repo.save(update);
    }

    public Boolean deleteNoteById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
