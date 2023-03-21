package fr.memoire.benchmark.controller;

import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.BookRequest;
import fr.memoire.benchmark.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> findAll(){
        return bookService.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }

    @GetMapping("/orderByTitle")
    public List<Book> findAllOrderByTitle(){
        return bookService.getBooksOrderByTitle();
    }

    //Ajout d'une route permettant de creer en masse

}
