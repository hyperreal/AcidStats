package info.hyperreal.acid.stats.configs;

import com.google.inject.AbstractModule;
import com.mattinsler.guiceymongo.guice.GuiceyMongo;

public class MongoConfigModule extends AbstractModule {

    public static final String DB_NAME = "ACID_STATS";
    public static final String STATS_ROW_COLLECTION = "STATS";

    @Override
    protected void configure() {
        install(GuiceyMongo.configure("DEV")
            .mapDatabase(DB_NAME).to("acid_stats")
            .mapCollection(STATS_ROW_COLLECTION).to("stats").inDatabase(DB_NAME));
        install(GuiceyMongo.configure("TEST")
            .mapDatabase(DB_NAME).to("acid_stats")
            .mapCollection(STATS_ROW_COLLECTION).to("stats").inDatabase(DB_NAME));
        install(GuiceyMongo.chooseConfiguration("DEV"));
    }
}
