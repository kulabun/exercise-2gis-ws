package ru.labun.doublegisexercise.service.doublegis;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by constantine on 06/02/16.
 */
class SearchResponse extends DoubleGisResponse {
    @JsonProperty("result")
    private List<SearchResult> results;

    public List<SearchResult> getResults() {
        return results;
    }

    public void setResults(List<SearchResult> results) {
        this.results = results;
    }
}
