package info.hyperreal.acid.stats.services;

import info.hyperreal.acid.stats.domain.Banner;
import info.hyperreal.acid.stats.domain.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class GainerService {

    @Inject
    private StatRowRepository statRowRepository;

    @GET
    @Path("/test")
    public String test() {
        return "Hello";
    }

    @GET
    @Path("/banner/{bannerId}/stats")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StatRow> getStatsForBanner(@PathParam("bannerId") int bannerId) throws BannerNotFoundException {
        return statRowRepository.findRowsByBanner(new Banner(bannerId, "a"));
    }
}
