package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Author;
import org.springframework.stereotype.Service;
import org.example.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
}
