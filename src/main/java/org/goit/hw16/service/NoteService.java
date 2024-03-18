package org.goit.hw16.service;

import java.util.List;
import java.util.Optional;
import org.goit.hw16.model.Note;
import org.goit.hw16.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Service
public class NoteService {

  private static final Logger logger = LoggerFactory.getLogger(NoteService.class);
  private final NoteRepository noteRepository;

  @Autowired
  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public List<Note> listAll() {
    logger.info("Listing all notes");
    return noteRepository.findAll();
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Note add(Note note) {
    Note savedNote = noteRepository.save(note);
    logger.info("Added note with id {}", savedNote.getId());
    return savedNote;
  }

  public void deleteById(Long id) {
    noteRepository.deleteById(id);
    logger.info("Deleted note with id {}", id);
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Note update(Note note) {
    if (note.getId() != null && noteRepository.existsById(note.getId())) {
      Note updatedNote = noteRepository.save(note);
      logger.info("Updated note with id {}", updatedNote.getId());
      return updatedNote;
    } else {
      logger.error("Note with id {} not found for update", note.getId());
      throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Optional<Note> getById(Long id) {
    Optional<Note> note = noteRepository.findById(id);
    if (note.isPresent()) {
      logger.info("Retrieved note with id {}", id);
    } else {
      logger.error("Note with id {} not found", id);
    }
    return note;
  }
}
