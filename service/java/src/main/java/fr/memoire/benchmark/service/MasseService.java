package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.AuthorRequest;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.Library;
import fr.memoire.benchmark.model.masse.MasseAuthorRequest;
import fr.memoire.benchmark.model.masse.MasseBookRequest;
import fr.memoire.benchmark.model.masse.MasseLibraryRequest;
import fr.memoire.benchmark.repository.AuthorRepository;
import fr.memoire.benchmark.repository.BookRepository;
import fr.memoire.benchmark.repository.LibraryRepository;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MasseService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    public void saveMasse(MasseLibraryRequest masseRequest){
        Library library = Library.builder()
                .name(masseRequest.getName())
                .build();
        Library librarySaved = libraryRepository.save(library);

        for(MasseAuthorRequest authorRequest : masseRequest.getMasseAuthorRequestList()){
            Author author = Author.builder()
                    .name(authorRequest.getName())
                    .library(librarySaved)
                    .build();

            Author authorSaved = authorRepository.save(author);

            for(MasseBookRequest bookRequest : authorRequest.getMasseBookRequests()){
                Book book = Book.builder()
                        .title(bookRequest.getTitle())
                        .synopsis(bookRequest.getSynopsis())
                        .author(authorSaved)
                        .build();

                Book bookSaved = bookRepository.save(book);
            }
        }
    }
}
