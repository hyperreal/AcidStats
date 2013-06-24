package info.hyperreal.acid.stats.services;

import info.hyperreal.acid.stats.domain.entities.Banner;
import info.hyperreal.acid.stats.domain.entities.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Named
@Path("/")
public class GainerService {

    @Inject
    private StatRowRepository statRowRepository;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() throws BannerNotFoundException {

        statRowRepository.findRowsByBanner(new Banner(1, "name"));
        return "Hello";
    }

    @GET
    @Path("/banner/{bannerId}/stats")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StatRow> getStatsForBanner(@PathParam("bannerId") int bannerId) throws BannerNotFoundException {
        return statRowRepository.findRowsByBanner(new Banner(bannerId, "a"));
    }
}
