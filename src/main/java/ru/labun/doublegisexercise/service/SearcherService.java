package ru.labun.doublegisexercise.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by constantine on 06/02/16.
 */
public interface SearcherService {
    Optional<Profile> getMostPopular(String where, String what);

    Optional<List<Profile>> getMostPopular(List<String> where, String what);
}
