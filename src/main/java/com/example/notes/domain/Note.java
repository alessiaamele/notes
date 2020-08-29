// Purpose of Entities: create a database with a set number of tables which have fields, essentially combining
// typical Java class and method language and SQL create principles

package com.example.notes.domain;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne(targetEntity = NoteBook.class)
    private NoteBook noteBook;

public Note(){

}

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {

    return id;
    }

    public void setId(Long id) {

    this.id = id;
    }

    public String getTitle() {

    return title;
    }

    public void setTitle(String title) {
    this.title = title;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }
}