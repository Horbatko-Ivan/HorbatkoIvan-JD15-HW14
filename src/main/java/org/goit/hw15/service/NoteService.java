package org.goit.hw15.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.goit.hw15.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Service
public class NoteService {

  public static final String NOTE_WITH_ID = "Note with id {} not found";
  private static final Logger logger = LoggerFactory.getLogger(NoteService.class);
  private final ConcurrentHashMap<Long, Note> notes = new ConcurrentHashMap<>();
  private final AtomicLong currentId = new AtomicLong(1);

  public List<Note> listAll() {
    logger.info("Listing all notes");
    return new ArrayList<>(notes.values());
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Note add(Note note) {
    long id = currentId.getAndIncrement();
    note.setId(id);
    notes.put(id, note);
    logger.info("Added note with id {}", id);
    return note;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void deleteById(long id) {
    if (notes.remove(id) == null) {
      logger.error(NOTE_WITH_ID, id);
      throw new IllegalArgumentException(String.format(NOTE_WITH_ID, id));
    } else {
      logger.info("Deleted note with id {}", id);
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void update(Note note) {
    if (note.getId() == null || notes.replace(note.getId(), note) == null) {
      logger.error(NOTE_WITH_ID, note.getId());
      throw new IllegalArgumentException(String.format(NOTE_WITH_ID, note.getId()));
    } else {
      logger.info("Updated note with id {}", note.getId());
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Note getById(long id) {
    Note note = notes.get(id);
    if (note == null) {
      logger.error(NOTE_WITH_ID, id);
      throw new IllegalArgumentException(String.format(NOTE_WITH_ID, id));
    } else {
      logger.info("Retrieved note with id {}", id);
      return note;
    }
  }
}
