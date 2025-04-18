package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Note;
import org.example.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Transactional
    public void createNote(Note note) {
        noteRepository.save(note);
    }

    @Transactional
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Transactional
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Transactional
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
