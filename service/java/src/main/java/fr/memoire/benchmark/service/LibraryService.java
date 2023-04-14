package fr.memoire.benchmark.service;

import fr.memoire.benchmark.bdd.ConnexionLibrary;
import fr.memoire.benchmark.model.Library;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    public List<Library> getLibraries(){
        try {
            return ConnexionLibrary.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Library saveLibrary(Library library){

        try {
            return ConnexionLibrary.save(library);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
