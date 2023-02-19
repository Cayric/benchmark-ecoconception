package fr.memoire.benchmark.repository;

import fr.memoire.benchmark.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
