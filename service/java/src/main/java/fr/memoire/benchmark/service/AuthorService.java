package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.AuthorRequest;
import fr.memoire.benchmark.model.Library;
import fr.memoire.benchmark.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    LibraryService libraryService;

    public Iterable<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author saveAuthor(AuthorRequest authorRequest){
        Library library = libraryService.getLibraryById(authorRequest.getLibraryId()).orElse(new Library());
        Author author = Author.builder()
                .name(authorRequest.getName())
                .library(library)
                .build();
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(Long id){
        return  authorRepository.findById(id);
    }
}
