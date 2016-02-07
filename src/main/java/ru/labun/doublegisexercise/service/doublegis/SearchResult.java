package ru.labun.doublegisexercise.service.doublegis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by constantine on 06/02/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class SearchResult {
    @JsonProperty("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
