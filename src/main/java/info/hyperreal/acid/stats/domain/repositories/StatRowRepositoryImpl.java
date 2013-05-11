package info.hyperreal.acid.stats.domain.repositories;

import com.google.inject.Singleton;
import info.hyperreal.acid.stats.domain.Banner;
import info.hyperreal.acid.stats.domain.StatRow;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class StatRowRepositoryImpl implements StatRowRepository {

    private Map<Integer, List<StatRow>> rows = new ConcurrentHashMap<Integer, List<StatRow>>();

    @Override
    public List<StatRow> findRowsByBanner(Banner banner) throws BannerNotFoundException {
        int bannerId = banner.getId();
        if (!rows.containsKey(bannerId)) {
            throw new BannerNotFoundException();
        }

        return rows.get(bannerId);
    }
}
