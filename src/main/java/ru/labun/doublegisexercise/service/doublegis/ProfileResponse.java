package ru.labun.doublegisexercise.service.doublegis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by constantine on 06/02/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ProfileResponse extends DoubleGisResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("city_name")
    private String city;

    @JsonProperty("address")
    private String address;

    @JsonProperty("rating")
    private String rating;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
