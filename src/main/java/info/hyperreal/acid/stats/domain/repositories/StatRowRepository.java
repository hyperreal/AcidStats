package info.hyperreal.acid.stats.domain.repositories;

import info.hyperreal.acid.stats.domain.entities.StatRow;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatRowRepository extends MongoRepository<StatRow, String> {
    public List<StatRow> findByBannerId(String bannerId) throws BannerNotFoundException;
}
