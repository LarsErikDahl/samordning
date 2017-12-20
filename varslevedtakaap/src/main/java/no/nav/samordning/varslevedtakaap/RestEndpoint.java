package no.nav.samordning.varslevedtakaap;

import no.nav.samordning.client.Client;
import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordningFeilFeilISendingMsg;
import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordningFeilHentVedtakFeilerMsg;
import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordningFeilTpnrIkkeFunnetMsg;
import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordningFeilVedtakIdIkkeFunnetMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestEndpoint {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private Client client;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) throws VarsleVedtakAAPSamordningFeilFeilISendingMsg, VarsleVedtakAAPSamordningFeilVedtakIdIkkeFunnetMsg, VarsleVedtakAAPSamordningFeilHentVedtakFeilerMsg, VarsleVedtakAAPSamordningFeilTpnrIkkeFunnetMsg, MalformedURLException {
        client.varsleVedtakAAP();
        return name + " " + counter.getAndIncrement();
    }
}
