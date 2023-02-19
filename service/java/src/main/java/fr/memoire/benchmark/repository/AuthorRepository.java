package fr.memoire.benchmark.repository;

import fr.memoire.benchmark.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
