// Purpose of the Exception file: manually set error messages for different errors we can expect the user to encounter

package com.example.notes.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.persistence.EntityNotFoundException;

// @ResponseStatus inputs two arguments:
// - the status code (example: 200 means all good, 404 means not found, 403 means denied access)
// - the message we want to display when encountering this error (is it the message the user is going to see?)
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason="NoteBook with this Id does not exist")
// EntityNotFoundException is an extension that needs to be added
public class NoteBookNotFoundException extends EntityNotFoundException {

}
