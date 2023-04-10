package fr.memoire.benchmark.model.masse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MasseAuthorRequest {

    private String name;

    @JsonProperty("books")
    private List<MasseBookRequest> masseBookRequests;
}
