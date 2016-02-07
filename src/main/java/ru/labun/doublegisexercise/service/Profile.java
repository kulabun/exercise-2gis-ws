package ru.labun.doublegisexercise.service;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by constantine on 06/02/16.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"Название", "Адрес", "Рейтинг Флампа"})
public interface Profile {
    @JsonProperty("Рейтинг Флампа")
    String getRating();

    @JsonProperty("Название")
    String getName();

    @JsonProperty("Адрес")
    String getAddress();
}
