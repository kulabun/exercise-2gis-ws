package ru.labun.doublegisexercise.service.doublegis;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.labun.doublegisexercise.service.Profile;
import ru.labun.doublegisexercise.service.SearcherService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by constantine on 06/02/16.
 */
public class SearcherServiceImpl implements SearcherService {
    private static Logger log = LogManager.getLogger(DoubleGisServiceImpl.class);
    @Inject
    private DoubleGisService doubleGisService;

    @Override
    public Profile getMostPopular(String where, String what) {
        SearchResponse response = doubleGisService.search(where, what, Sorting.rating);

        if (response.isError()) {
            log.warn(response.getErrorMessage());
            return null;
        }

        if (response.getResults() == null) {
            log.info(String.format("Zero results for where=`%1$s` and what=`%2$s`",
                    where, what));
            return null;
        }

        String profileId = response.getResults().stream().findFirst()
                .map(SearchResult::getId)
                .orElse(null);

        if (profileId == null) {
            return null;
        }

        return getProfile(profileId);
    }

    private Profile getProfile(String profileId) {
        ProfileResponse response = doubleGisService.profile(profileId);
        if (response.isError()) {
            log.warn(response.getErrorMessage());
            return null;
        }
        return ProfileResponseWrapper.wrap(response);
    }

    @Override
    public List<Profile> getMostPopular(List<String> where, String what) {
        return where.parallelStream()
                .map(it -> getMostPopular(it, what))
                .filter(it -> it != null)
                .sorted((o1, o2) -> {
                    String o1Rate = ObjectUtils.defaultIfNull(o1.getRating(), "0.0");
                    String o2Rate = ObjectUtils.defaultIfNull(o2.getRating(), "0.0");
                    return -1 * o1Rate.compareTo(o2Rate);
                })
                .collect(Collectors.toList());
    }
}
