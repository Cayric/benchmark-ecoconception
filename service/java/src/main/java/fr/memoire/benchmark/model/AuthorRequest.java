package fr.memoire.benchmark.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class AuthorRequest {

    private String name;

    private Long libraryId;

}
