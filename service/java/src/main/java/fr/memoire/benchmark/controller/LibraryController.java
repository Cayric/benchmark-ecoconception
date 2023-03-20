package fr.memoire.benchmark.controller;

import fr.memoire.benchmark.model.Library;
import fr.memoire.benchmark.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public Page<Library> findAll(){
        return libraryService.getLibraries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Library save(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }
}
