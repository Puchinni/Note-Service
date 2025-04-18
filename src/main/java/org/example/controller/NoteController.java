package org.example.controller;

import org.example.model.Author;
import org.example.model.Note;
import org.example.service.AuthorService;
import org.example.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final AuthorService authorService;

    public NoteController(NoteService noteService, AuthorService authorService) {
        this.noteService = noteService;
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        if (note.isPresent()) {
            return ResponseEntity.ok(note.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createNote(@RequestBody Note note, Long authorId) {
        Optional<Author> author = authorService.getAuthorById(authorId);
        if (author.isPresent()) {
            note.setAuthor(author.get());
            noteService.createNote(note);
            return ResponseEntity.ok("Note created");
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        if (note.isPresent()) {
            noteService.deleteNoteById(id);
            return ResponseEntity.ok("Note deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
