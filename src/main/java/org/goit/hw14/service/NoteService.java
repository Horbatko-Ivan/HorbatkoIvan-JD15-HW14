package org.goit.hw14.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.goit.hw14.model.Note;
import org.springframework.stereotype.Service;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Service
public class NoteService {

  public static final String NOTE_WITH_ID = "Note with id ";
  public static final String NOT_FOUND = " not found";
  private final Map<Long, Note> notes = new HashMap<>();
  private long currentId = 1;

  public List<Note> listAll() {
    return new ArrayList<>(notes.values());
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Note add(Note note) {
    note.setId(currentId++);
    notes.put(note.getId(), note);
    return note;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void deleteById(long id) {
    if (!notes.containsKey(id)) {
      throw new IllegalArgumentException(NOTE_WITH_ID + id + NOT_FOUND);
    }
    notes.remove(id);
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void update(Note note) {
    if (!notes.containsKey(note.getId())) {
      throw new IllegalArgumentException(NOTE_WITH_ID + note.getId() + NOT_FOUND);
    }
    notes.put(note.getId(), note);
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Note getById(long id) {
    Note note = notes.get(id);
    if (note == null) {
      throw new IllegalArgumentException(NOTE_WITH_ID + id + NOT_FOUND);
    }
    return note;
  }
}
