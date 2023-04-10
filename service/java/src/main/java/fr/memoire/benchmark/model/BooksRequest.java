package fr.memoire.benchmark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BooksRequest {
    private List<BookRequest> bookRequest;
}
