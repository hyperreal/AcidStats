package info.hyperreal.acid.stats.domain.repositories.impl;

import com.mattinsler.guiceymongo.guice.annotation.MongoCollection;
import com.mattinsler.guiceymongo.guice.annotation.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import info.hyperreal.acid.stats.domain.entities.Banner;
import info.hyperreal.acid.stats.domain.entities.StatRow;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.exceptions.BannerNotFoundException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatRowRepositoryImpl implements StatRowRepository {

    private DB database;
    private DBCollection collection;

    private Map<Integer, List<StatRow>> rows = new ConcurrentHashMap<>();

    @Inject
    public StatRowRepositoryImpl(@MongoDatabase("MAIN") DB database,
                                 @MongoCollection("STATS") DBCollection collection) {
        this.database = database;
        this.collection = collection;
    }

    @Override
    public List<StatRow> findRowsByBanner(Banner banner) throws BannerNotFoundException {
        collection.insert(new BasicDBObject("dupa", "test"));

        int bannerId = banner.getId();
        if (!rows.containsKey(bannerId)) {
            throw new BannerNotFoundException();
        }

        return rows.get(bannerId);
    }
}
