// Purpose of the Repository: Convert the entities created in Java in SQL by using the JpaRepository extension
// Similarly, retrieves info from SQL and translates them into Java

package com.example.notes.repo;

import com.example.notes.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}