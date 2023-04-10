package fr.memoire.benchmark.controller;

import fr.memoire.benchmark.model.masse.MasseLibraryRequest;
import fr.memoire.benchmark.service.MasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masse")
public class MasseController {
    @Autowired
    private MasseService masseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MasseLibraryRequest masseRequest) {
        masseService.saveMasse(masseRequest);
    }

}
