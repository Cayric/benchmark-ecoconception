package fr.memoire.benchmark.model.masse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MasseLibraryRequest {

    private String name;

    @JsonProperty("authors")
    private List<MasseAuthorRequest> masseAuthorRequestList;

}
