package ru.labun.doublegisexercise;

import ru.labun.doublegisexercise.service.Profile;
import ru.labun.doublegisexercise.service.SearcherService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;

/**
 * Created by constantine on 06/02/16.
 */
@Singleton
@Path("/syberia-searcher")
public class SyberiaSearchResource {
    private List<String> syberiaCities = Arrays.asList("Новосибирск", "Омск", "Томск", "Кемерово", "Новокузнецк");
    @Inject
    private SearcherService searcherService;

    @GET
    @Path("/{what}")
    @Produces("application/json;charset=utf-8")
    public List<Profile> search(@NotNull @PathParam("what") String what) {
        return searcherService.getMostPopular(syberiaCities, what);
    }
}
