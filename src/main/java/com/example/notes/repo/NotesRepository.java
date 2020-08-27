package com.example.notes.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}
