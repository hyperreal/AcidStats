package info.hyperreal.acid.stats.services;

import info.hyperreal.acid.stats.exceptions.AcidStatsEntityException;
import info.hyperreal.acid.stats.services.utils.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AcidStatsExceptionMapper implements ExceptionMapper<AcidStatsEntityException> {

    @Override
    public Response toResponse(AcidStatsEntityException e) {
        if (e.getEntity() == null) {
            return Response.status(Response.Status.NOT_FOUND).
                entity(new ErrorMessage("Not found")).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                entity(new ErrorMessage("Internal server error")).build();
        }
    }
}
