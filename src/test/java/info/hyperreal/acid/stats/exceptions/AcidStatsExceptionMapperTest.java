package info.hyperreal.acid.stats.exceptions;

import static org.junit.Assert.*;

import info.hyperreal.acid.stats.domain.Banner;
import info.hyperreal.acid.stats.services.AcidStatsExceptionMapper;
import org.junit.Test;

import javax.ws.rs.core.Response;

public class AcidStatsExceptionMapperTest {

    AcidStatsExceptionMapper mapper = new AcidStatsExceptionMapper();

    @Test
    public void bannerNotFoundToResponse() {
        Response response = mapper.toResponse(new BannerNotFoundException());
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void acidStatsEntityToResponseWithEntity() {
        Banner banner = new Banner(1, "name");
        Response response = mapper.toResponse(new AcidStatsEntityException("message", banner));
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void acidStatsEntityToResponseWithoutEntity() {
        Response response = mapper.toResponse(new AcidStatsEntityException("message"));
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
