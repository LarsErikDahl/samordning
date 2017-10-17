package no.nav.samordning.health;

import org.springframework.stereotype.Component;

@Component
public class HealthChecker {
    private boolean isReady = false;

    public boolean isReady() {
        return isReady;
    }

    /**
     * Sets the application to be in a healthy state. (Cannot be toggled)
     */
    public void setAsReady() {
        isReady = true;
    }
}
