// Purpose of Entities: create a database with a set number of tables which have fields, essentially combining
// typical Java class and method language and SQL create principles

package com.example.notes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

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
}