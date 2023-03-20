package fr.memoire.benchmark.service;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.Library;
import fr.memoire.benchmark.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Page<Library> getLibraries(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        return libraryRepository.findAll(pageable);
    }

    public Library saveLibrary(Library library){
        return libraryRepository.save(library);
    }

    public Optional<Library> getLibraryById(Long id){
        return  libraryRepository.findById(id);
    }


}
