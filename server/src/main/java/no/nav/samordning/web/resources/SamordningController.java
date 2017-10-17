package no.nav.samordning.web.resources;

import no.nav.samordning.health.HealthChecker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("api/internal")
public class SamordningController {

    @Inject
    HealthChecker healthChecker;

    @RequestMapping(value = "/isAlive", method = RequestMethod.GET)
    public String isAlive() {
        return "OK";
    }

    @RequestMapping(value = "/isReady", method = RequestMethod.GET)
    public String isReady() {
        if(healthChecker.isReady()) {
            return "OK";
        } else {
            return "NOT OK";    // TODO Not correct response
        }
    }
}
