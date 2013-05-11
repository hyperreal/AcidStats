package info.hyperreal.acid.stats.di;

import com.google.inject.AbstractModule;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepository;
import info.hyperreal.acid.stats.domain.repositories.StatRowRepositoryImpl;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StatRowRepository.class).to(StatRowRepositoryImpl.class);
    }

}
