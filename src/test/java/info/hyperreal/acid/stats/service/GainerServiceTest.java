package info.hyperreal.acid.stats.service;

import info.hyperreal.acid.stats.domain.Banner;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class GainerServiceTest {

    @Mock
    private StatRowRepository repository = mock(StatRowRepository.class);

    @InjectMocks
    private GainerService service = new GainerService();

    @Before
    public void prepare() {
    }

    @Test(expected = Exception.class)
    public void test1() {
        when(repository.findRowsByBanner(any(Banner.class))).thenThrow(new Exception("Kurwa"));
        System.out.println(service.test());
    }
}
