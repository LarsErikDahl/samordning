package no.nav.samordning;

import io.prometheus.client.hotspot.DefaultExports;
import no.nav.samordning.health.HealthChecker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Inject
    HealthChecker healthChecker;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        healthChecker.setAsReady();
        DefaultExports.initialize();
    }
}

