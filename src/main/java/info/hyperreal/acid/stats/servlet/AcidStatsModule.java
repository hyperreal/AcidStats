package info.hyperreal.acid.stats.servlet;

import com.google.inject.AbstractModule;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepositoryImpl;

public class AcidStatsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StatRowRepository.class).to(StatRowRepositoryImpl.class);
    }
}
