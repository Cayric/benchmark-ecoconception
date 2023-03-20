package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.BookRequest;
import fr.memoire.benchmark.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Data
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public Page<Book> getBooks(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        return bookRepository.findAll(pageable);
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
}
