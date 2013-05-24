package info.hyperreal.acid.stats.domain.repositories.impl;

import info.hyperreal.acid.stats.domain.entities.Banner;
import info.hyperreal.acid.stats.domain.entities.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatRowRepositoryImpl implements StatRowRepository {

    private Map<Integer, List<StatRow>> rows = new ConcurrentHashMap<>();

    @Override
    public List<StatRow> findRowsByBanner(Banner banner) throws BannerNotFoundException {
        int bannerId = banner.getId();
        if (!rows.containsKey(bannerId)) {
            throw new BannerNotFoundException();
        }

        return rows.get(bannerId);
    }
}
