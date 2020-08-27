package com.example.notes.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason="Note with this Id does not exist")
public class NoteNotFoundException extends EntityNotFoundException {

}
