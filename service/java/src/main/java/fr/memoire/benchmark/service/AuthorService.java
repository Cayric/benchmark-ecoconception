package fr.memoire.benchmark.service;

import fr.memoire.benchmark.bdd.ConnexionAuthor;
import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.AuthorRequest;
import fr.memoire.benchmark.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    LibraryService libraryService;

    public List<Author> getAuthors(){
        try {
            return ConnexionAuthor.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Author saveAuthor(AuthorRequest authorRequest){
        Author author = Author.builder()
                .name(authorRequest.getName())
                .libraryID(authorRequest.getLibraryId())
                .build();
        try {
            return ConnexionAuthor.save(author);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Author> getAuthorById(Long id){

        return Optional.of(new Author());
    }
}
