package fr.memoire.benchmark.controller;

import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.BookRequest;
import fr.memoire.benchmark.model.BooksRequest;
import fr.memoire.benchmark.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/booksPagination")
    public Page<Book> findPageAndSort(){
        return bookService.getBooksPageableOrderByTitle();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> save(@RequestBody BooksRequest bookRequests) {
        return bookService.saveBooks(bookRequests);
    }

    @GetMapping("/order-by-title")
    public List<Book> findAllOrderByTitle(){
        return bookService.getBooksOrderByTitle();
    }

}
