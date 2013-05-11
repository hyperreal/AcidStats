package info.hyperreal.acid.stats.service;

import com.sun.jersey.api.NotFoundException;
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
    @Path("/banner/{bannerId}/stats")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatRow> getStatsForBanner(@PathParam("bannerId") int bannerId) {
        try {
            return statRowRepository.findRowsByBanner(new Banner(bannerId, "a"));
        } catch (BannerNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
