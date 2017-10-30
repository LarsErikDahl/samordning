package no.nav.samordning.testwsdl;

import no.nav.samordning.varslevedtaksamordning.inf.ObjectFactory;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordning;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordningResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VarsleVedtakSamordningEndpoint {
    public static final String NAMESPACE_URI = "http://nav.no/samordning/varslevedtaksamordning/inf";

    private static final Logger LOG = LoggerFactory.getLogger(VarsleVedtakSamordningEndpoint.class);

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "varsleVedtakSamordning")
    @ResponsePayload
    public VarsleVedtakSamordningResponse testQuery(@RequestPayload VarsleVedtakSamordning varsleVedtakSamordning) {
        LOG.info("reached 1");
        ObjectFactory factory = new ObjectFactory();
        LOG.info("reached 2");
        VarsleVedtakSamordningResponse test = factory.createVarsleVedtakSamordningResponse();
        LOG.info("reached 3");
        LOG.info("vvs: " + varsleVedtakSamordning);
        LOG.info("vvs.vvsr: " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest());
        LOG.info("vvs.vvsr.fnr: " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getGjelderFnr());
        LOG.info("vvs.vvsr.tpnr: " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getTpnr());
        test.setVarsleVedtakSamordningResponse("fnr: " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getGjelderFnr() + " " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getTpnr());
        LOG.info("reached 4");

        return test;
    }
}
