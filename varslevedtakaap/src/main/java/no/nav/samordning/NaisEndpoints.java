package no.nav.samordning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaisEndpoints {

    @RequestMapping("/isAlive")
    public String isAlive() {
        return "YES";
    }

    @RequestMapping("/isReady")
    public String isReady() {
        return "YES";
    }
}

