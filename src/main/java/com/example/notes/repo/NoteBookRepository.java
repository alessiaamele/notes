package com.example.notes.repo;

import com.example.notes.domain.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteBookRepository extends JpaRepository<NoteBook, Long> {
}
