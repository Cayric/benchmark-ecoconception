package fr.memoire.benchmark.repository;

import fr.memoire.benchmark.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByOrderByTitleDesc();
    Page<Book> findAll(Pageable pageable);

}
