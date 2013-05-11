package info.hyperreal.acid.stats.service;

import com.sun.jersey.api.NotFoundException;
import info.hyperreal.acid.stats.domain.StatRow;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/")
public class GainerService {

    private static Map<Integer, StatRow> rows = new ConcurrentHashMap<Integer, StatRow>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/row")
    public Response add(StatRow row) {
        rows.put(row.getId(), row);

        URI location = URI.create(String.valueOf(row.getId()));
        return Response.created(location).build();
    }


    @GET
    @Path("/row/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StatRow getRow(@PathParam("id") int id) throws NotFoundException {
        if (rows.containsKey(id)) {
            return rows.get(id);
        }

        throw new NotFoundException("Not found, kurwa");
    }
}
