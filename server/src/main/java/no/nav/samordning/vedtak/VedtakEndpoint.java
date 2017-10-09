package no.nav.samordning.vedtak;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/hentVedtak")
public class VedtakEndpoint {
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping(method = RequestMethod.GET)
    public VedtakDTO hentVedtak(@RequestParam(value="id") String t) {
        return new VedtakDTO(t, counter.incrementAndGet());
    }
}
