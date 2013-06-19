package info.hyperreal.acid.stats.configs;

import com.google.inject.AbstractModule;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.domain.repositories.impl.StatRowRepositoryImpl;

public class StatsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StatRowRepository.class).to(StatRowRepositoryImpl.class);
    }


}
