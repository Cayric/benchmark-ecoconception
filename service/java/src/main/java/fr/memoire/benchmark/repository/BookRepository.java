package fr.memoire.benchmark.repository;

import fr.memoire.benchmark.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
