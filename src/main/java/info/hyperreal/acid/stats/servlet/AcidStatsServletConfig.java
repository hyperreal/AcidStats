package info.hyperreal.acid.stats.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

public class AcidStatsServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                install(new AcidStatsModule());
                serve("/*").with(GuiceContainer.class, getServletParams());
            }

            private Map<String, String> getServletParams() {
                Map<String, String> params = new HashMap<>();
                params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
                params.put("com.sun.jersey.config.property.packages", "info.hyperreal.acid.stats.services");
                return params;
            }
        });
    }
}
