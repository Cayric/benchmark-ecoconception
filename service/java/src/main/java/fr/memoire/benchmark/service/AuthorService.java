package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.AuthorRequest;
import fr.memoire.benchmark.model.Library;
import fr.memoire.benchmark.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    LibraryService libraryService;

    public Page<Author> getAuthors(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        return authorRepository.findAll(pageable);
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
