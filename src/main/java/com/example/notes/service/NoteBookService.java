package com.example.notes.service;

import com.example.notes.domain.NoteBook;
import com.example.notes.exceptions.NoteBookNotFoundException;
import com.example.notes.exceptions.NoteNotFoundException;
import com.example.notes.repo.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteBookService {

    private final NoteBookRepository repo;

    @Autowired
    public NoteBookService(NoteBookRepository repo) {
        this.repo = repo;
    }

    // Functionality 1: get all notes from database so they can be displayed. The app already runs with only this field (doesn't do much but still)
    public List<NoteBook> readAllNoteBook(){

        return this.repo.findAll();
    }

    // Functionality 2: Create Notes
    public NoteBook createNoteBook(NoteBook noteBook){
        return this.repo.save(noteBook);
    }

    // Functionality 3: Find Notes by Id <- returns an optional in case Id Not found, and here we generate the
    // NoteNotFoundException class in parallel which will display the message of our choice
    // NB: findById (in-built function) returns an optional
    public NoteBook findNoteBookById(Long id){
        return this.repo.findById(id).orElseThrow(NoteBookNotFoundException::new);
    }

    // Functionality 4: Updating a previous record
    // a bit complicated, look at the notes and ask questions - still okayish intuitive
    // the save feature detects if there is an Id or not (if not it will store the entity as new object, if yes it will update it)

    public NoteBook updateNoteBook(Long id, NoteBook noteBook){
        NoteBook update = findNoteBookById(id);
        update.setName(noteBook.getName());
        return this.repo.save(update);
    }

    // Functionality 5: Deleting a record
    // Will return true if the record has been successfully deleted, false if it hasn't
    public Boolean deleteNoteBookById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
