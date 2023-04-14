package fr.memoire.benchmark.service;

import fr.memoire.benchmark.bdd.ConnexionBook;
import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.BookRequest;
import fr.memoire.benchmark.model.BooksRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class BookService {

    public List<Book> getBooks(){
        try {
            return ConnexionBook.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Book saveBook(BookRequest bookRequest){
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .synopsis(bookRequest.getSynopsis())
                .author_id(bookRequest.getAuthorId())
                .build();
        try {
            return ConnexionBook.save(book);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> saveBooks(BooksRequest bookRequests) {
        List<Book> books = new ArrayList<>();
        for(BookRequest bookRequest : bookRequests.getBookRequest()){
            books.add(saveBook(bookRequest));
        }
        return books;
    }

}
