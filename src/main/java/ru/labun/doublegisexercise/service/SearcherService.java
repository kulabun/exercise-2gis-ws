package ru.labun.doublegisexercise.service;

import java.util.List;

/**
 * Created by constantine on 06/02/16.
 */
public interface SearcherService {
    Profile getMostPopular(String where, String what);

    List<Profile> getMostPopular(List<String> where, String what);
}
