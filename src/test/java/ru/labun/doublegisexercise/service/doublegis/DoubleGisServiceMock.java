package ru.labun.doublegisexercise.service.doublegis;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

/**
 * Created by constantine on 07/02/16.
 */
public class DoubleGisServiceMock implements DoubleGisService {
    private ObjectMapper mapper;
    private SearchResponse searchNotFoundResponse;
    private ProfileResponse profileNotFoundResponse;


    public DoubleGisServiceMock() {
        this.mapper = new ObjectMapper();
        this.profileNotFoundResponse = readResponse("/response/profile/not_found.json", ProfileResponse.class);
        this.searchNotFoundResponse = readResponse("/response/search/not_found.json", SearchResponse.class);
    }

    private <T> T readResponse(String path, Class<T> clazz) {
        try {
            URL resource = DoubleGisServiceMock.class.getResource(path);
            if (resource == null) {
                return null;
            }
            return mapper.readValue(resource, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProfileResponse profile(String profileId) {
        ProfileResponse response = readResponse("/response/profile/" + profileId + ".json", ProfileResponse.class);
        return response != null ?
                response :
                profileNotFoundResponse;
    }

    @Override
    public SearchResponse search(String where, String what, Sorting sort) {
        try {
            String path = String.format("/response/search/%1$s_%2$s.json",
                    where.toLowerCase(), what.toLowerCase());
            SearchResponse response = readResponse(path, SearchResponse.class);
            return response != null ?
                    response :
                    searchNotFoundResponse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
