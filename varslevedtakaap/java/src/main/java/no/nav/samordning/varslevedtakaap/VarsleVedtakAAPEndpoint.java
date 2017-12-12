package no.nav.samordning.varslevedtakaap;

import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordning;
import no.nav.samordning.tjenester.varslevedtakaap.v1.meldinger.VarsleVedtakAAPSamordningRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VarsleVedtakAAPEndpoint {


    public static final String NAMESPACE_URI = "http://nav.no/samordning/tjenester/varslevedtakaap/v1";

    private static final Logger LOG = LoggerFactory.getLogger(VarsleVedtakAAPEndpoint.class);

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "varsleVedtakAAPSamordning")
    //@ResponsePayload
    public void testQuery(@RequestPayload VarsleVedtakAAPSamordning varsleVedtakAAPSamordning) {
        LOG.info("varsleVedtakAAPSamordning er blitt kalt");
        LOG.info("varsleVedtakAAPSamordning er blitt kalt - req: " + varsleVedtakAAPSamordning.getVarsleVedtakAAPSamordningRequest());
        LOG.info("varsleVedtakAAPSamordning er blitt kalt - req.tpnr: " + varsleVedtakAAPSamordning.getVarsleVedtakAAPSamordningRequest().getTpnr());
        LOG.info("varsleVedtakAAPSamordning er blitt kalt - fnr: " + varsleVedtakAAPSamordning.getVarsleVedtakAAPSamordningRequest().getFnr() + " tpnrs: " + varsleVedtakAAPSamordning.getVarsleVedtakAAPSamordningRequest().getTpnr().size() + " vid: " + varsleVedtakAAPSamordning.getVarsleVedtakAAPSamordningRequest().getVedtakID());
        return;
    }
}

