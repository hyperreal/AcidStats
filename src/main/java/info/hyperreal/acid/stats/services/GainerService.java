package info.hyperreal.acid.stats.services;

import info.hyperreal.acid.stats.domain.entities.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    StatRowRepository repository;

    @GET
    @Path("/rows/{bannerId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<StatRow> getRow(@PathParam("bannerId") String bannerId) throws BannerNotFoundException {
        final List<StatRow> rows = repository.findByBannerId(bannerId);
        if (rows.isEmpty()) {
            throw new BannerNotFoundException();
        }

        return rows;
    }

    @GET
    @Path("/hello")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public StatRow hello() {
        final StatRow statRow = new StatRow("ajdi", "Nazwa");
        statRow.setBannerId("ID bannera");
        return statRow;
    }
}
