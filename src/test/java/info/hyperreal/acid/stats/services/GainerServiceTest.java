package info.hyperreal.acid.stats.services;

import com.sun.jersey.api.NotFoundException;
import info.hyperreal.acid.stats.domain.Banner;
import info.hyperreal.acid.stats.domain.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

public class GainerServiceTest {

    @Mock
    private StatRowRepository repository;

    @InjectMocks
    private GainerService service = new GainerService();

    @Before
    public void prepareMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NotFoundException.class)
    public void bannerNotFoundExceptionIsPropagated() {
        when(repository.findRowsByBanner(any(Banner.class))).thenThrow(new BannerNotFoundException());
        service.getStatsForBanner(8);
    }

    @Test
    public void returnsEmptyList() {
        when(repository.findRowsByBanner(any(Banner.class)))
            .thenReturn(new ArrayList<StatRow>());

        Assert.assertEquals(0, service.getStatsForBanner(7).size());
    }

    @Test
    public void returnsNonEmptyList() {
        final StatRow statRow = new StatRow(1, "name");
        final ArrayList<StatRow> statRows = new ArrayList<StatRow>();
        statRows.add(statRow);
        when(repository.findRowsByBanner(any(Banner.class))).thenReturn(statRows);

        Assert.assertEquals(statRow, service.getStatsForBanner(9).iterator().next());
    }
}
