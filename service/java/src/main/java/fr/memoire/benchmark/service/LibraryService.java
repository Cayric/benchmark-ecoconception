package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Library;
import fr.memoire.benchmark.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Library saveLibrary(Library library){
        return libraryRepository.save(library);
    }

    public Optional<Library> getLibraryById(Long id){
        return  libraryRepository.findById(id);
    }


}
