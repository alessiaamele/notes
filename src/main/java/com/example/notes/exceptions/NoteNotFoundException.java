package com.example.notes.exceptions;

public class NoteNotFoundException extends EntityNotFoundException{

    @ResponseStatus(code=HttpStatus.NOT_FOUND, reason= "The note with this id doesn't exist")


}
