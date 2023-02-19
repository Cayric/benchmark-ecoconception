package fr.memoire.benchmark.repository;

import fr.memoire.benchmark.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
