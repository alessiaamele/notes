package com.example.notes.domain;

import javax.persistence.Entity;
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
}
