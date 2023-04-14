package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.BookRequest;
import fr.memoire.benchmark.model.BooksRequest;
import fr.memoire.benchmark.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksOrderByTitle(){
        return bookRepository.findByOrderByTitleDesc();
    }

    public Book saveBook(BookRequest bookRequest){
        Author author = authorService.getAuthorById(bookRequest.getAuthorId()).orElse(new Author());
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .synopsis(bookRequest.getSynopsis())
                .author(author)
                .build();
        return bookRepository.save(book);
    }

    public List<Book> saveBooks(BooksRequest bookRequests) {
        List<Book> books = new ArrayList<>();
        for(BookRequest bookRequest : bookRequests.getBookRequest()){
            books.add(saveBook(bookRequest));
        }
        return books;
    }

    public Page<Book> getBooksPageableOrderByTitle(){
        Pageable paging = PageRequest.of(0, 100, Sort.by("title"));
        return bookRepository.findAll(paging);
    }
}
