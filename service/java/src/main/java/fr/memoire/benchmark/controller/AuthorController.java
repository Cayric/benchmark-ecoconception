package fr.memoire.benchmark.controller;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.AuthorRequest;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Iterable<Author> findAll(){
        return authorService.getAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody AuthorRequest authorRequest) {
        return authorService.saveAuthor(authorRequest);
    }
}
