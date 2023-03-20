package fr.memoire.benchmark.repository;

import fr.memoire.benchmark.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
