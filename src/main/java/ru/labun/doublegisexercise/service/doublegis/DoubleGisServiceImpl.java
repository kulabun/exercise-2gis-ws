package ru.labun.doublegisexercise.service.doublegis;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Created by constantine on 06/02/16.
 */
public class DoubleGisServiceImpl implements DoubleGisService {
    public static final String PARAM_SORT = "sort";
    private static final String DOUBLEGIS_BASE_URL = "http://catalog.api.2gis.ru/";
    private static final String PATH_PROFILE = "profile";
    private static final String PATH_SEARCH = "search";
    private static final String PARAM_API_KEY = "key";
    private static final String PARAM_PROFILE_ID = "id";
    private static final String PARAM_VERSION = "version";
    private static final String PARAM_WHERE = "where";
    private static final String PARAM_WHAT = "what";
    private final String API_VERISON = "1.3";
    private final String API_KEY = "<SUPER_SECRET>";
    private final Client wsClient;

    public DoubleGisServiceImpl() {
        wsClient = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }

    public ProfileResponse profile(String profileId) {
        return wsClient.target(DOUBLEGIS_BASE_URL)
                .path(PATH_PROFILE)
                .queryParam(PARAM_VERSION, API_VERISON)
                .queryParam(PARAM_API_KEY, API_KEY)
                .queryParam(PARAM_PROFILE_ID, profileId)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(ProfileResponse.class);
    }

    public SearchResponse search(String where, String what, Sorting sorting) {
        return wsClient.target(DOUBLEGIS_BASE_URL)
                .path(PATH_SEARCH)
                .queryParam(PARAM_VERSION, API_VERISON)
                .queryParam(PARAM_API_KEY, API_KEY)
                .queryParam(PARAM_WHERE, where)
                .queryParam(PARAM_WHAT, what)
                .queryParam(PARAM_SORT, sorting.name())
                .request()
                .get()
                .readEntity(SearchResponse.class);
    }
}
