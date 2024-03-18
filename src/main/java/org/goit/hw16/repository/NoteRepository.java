package org.goit.hw16.repository;

import org.goit.hw16.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("checkstyle:MissingJavadocType")
public interface NoteRepository extends JpaRepository<Note, Long> {

}
