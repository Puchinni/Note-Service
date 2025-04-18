package org.example.controller;

import org.example.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.service.AuthorService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.ok("Author created");
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@RequestParam Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        }
        return ResponseEntity.notFound().build();
    }
}
