package fr.memoire.benchmark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String synopsis;

    @JsonProperty("author_id")
    private Long authorId;
}
