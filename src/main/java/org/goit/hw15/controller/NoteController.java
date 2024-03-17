package org.goit.hw15.controller;

import org.goit.hw15.model.Note;
import org.goit.hw15.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Controller
@RequestMapping("/note")
public class NoteController {

  private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
  private final NoteService noteService;

  @Autowired
  public NoteController(NoteService noteService) {
    this.noteService = noteService;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  @GetMapping("/list")
  public String listNotes(Model model) {
    logger.info("Accessing note list page.");
    model.addAttribute("notes", noteService.listAll());
    return "note_list";
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  @PostMapping("/delete")
  public String deleteNote(@RequestParam Long id) {
    logger.info("Deleting note with id: {}", id);
    noteService.deleteById(id);
    return "redirect:/note/list";
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  @GetMapping("/edit")
  public String editNoteForm(@RequestParam(required = false) Long id, Model model) {
    logger.info("Accessing noteEditForm page.");
    if (id != null) {
      Note note = noteService.getById(id);
      model.addAttribute("note", note);
    } else {
      model.addAttribute("note", new Note());
    }
    return "note_edit";
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  @PostMapping("/edit")
  public String editNote(Note note) {
    logger.info("Processing note edit.");
    if (note.getId() != null) {
      noteService.update(note);
    } else {
      noteService.add(note);
    }
    return "redirect:/note/list";
  }
}
