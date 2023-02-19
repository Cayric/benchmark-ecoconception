package fr.memoire.benchmark.model;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private Long authorId;
}
