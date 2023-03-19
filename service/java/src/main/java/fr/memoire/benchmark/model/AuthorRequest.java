package fr.memoire.benchmark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class AuthorRequest {

    private String name;

    @JsonProperty("library_id")
    private Long libraryId;

}
