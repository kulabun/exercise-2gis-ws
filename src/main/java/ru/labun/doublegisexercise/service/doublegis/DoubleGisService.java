package ru.labun.doublegisexercise.service.doublegis;

/**
 * Created by constantine on 06/02/16.
 */
public interface DoubleGisService {
    ProfileResponse profile(String profileId);

    SearchResponse search(String where, String what, Sorting sort);
}
