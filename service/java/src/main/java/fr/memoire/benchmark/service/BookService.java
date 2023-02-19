package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.BookRequest;
import fr.memoire.benchmark.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Book saveBook(BookRequest bookRequest){
        Author author = authorService.getAuthorById(bookRequest.getAuthorId()).orElse(new Author());
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .author(author)
                .build();
        return bookRepository.save(book);
    }
}
