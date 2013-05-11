package info.hyperreal.acid.stats.domain.repositories;

import info.hyperreal.acid.stats.domain.Banner;
import info.hyperreal.acid.stats.domain.StatRow;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;

import java.util.List;

public interface StatRowRepository {

    public List<StatRow> findRowsByBanner(Banner banner) throws BannerNotFoundException;

}
