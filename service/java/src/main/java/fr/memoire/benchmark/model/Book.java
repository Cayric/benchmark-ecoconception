package fr.memoire.benchmark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    private Long id;

    private String title;

    @Lob
    private String synopsis;

    private Long author_id;

}
