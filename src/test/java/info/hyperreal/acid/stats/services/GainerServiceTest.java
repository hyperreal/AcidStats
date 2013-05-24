package info.hyperreal.acid.stats.services;

import info.hyperreal.acid.stats.domain.entities.Banner;
import info.hyperreal.acid.stats.domain.entities.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GainerServiceTest {

    @Mock
    private StatRowRepository repository;

    @InjectMocks
    private GainerService service = new GainerService();


    @Test(expected = BannerNotFoundException.class)
    public void bannerNotFoundExceptionIsPropagated() throws BannerNotFoundException {
        when(repository.findRowsByBanner(any(Banner.class))).thenThrow(new BannerNotFoundException());
        service.getStatsForBanner(8);
    }

    @Test
    public void returnsEmptyList() throws BannerNotFoundException {
        when(repository.findRowsByBanner(any(Banner.class)))
            .thenReturn(new ArrayList<StatRow>());

        Assert.assertEquals(0, service.getStatsForBanner(7).size());
    }

    @Test
    public void returnsNonEmptyList() throws BannerNotFoundException {
        final StatRow statRow = new StatRow(1, "name");
        final ArrayList<StatRow> statRows = new ArrayList<>();
        statRows.add(statRow);
        when(repository.findRowsByBanner(any(Banner.class))).thenReturn(statRows);

        Assert.assertEquals(statRow, service.getStatsForBanner(9).iterator().next());
    }
}
