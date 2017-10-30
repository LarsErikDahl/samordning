package no.nav.samordning.varslevedtaksamordning;

import no.nav.samordning.varslevedtaksamordning.inf.ObjectFactory;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordning;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordningResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class VarsleVedtakSamordningEndpoint {
    public static final String NAMESPACE_URI = "http://nav.no/samordning/varslevedtaksamordning/inf";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "varsleVedtakSamordning")
    @ResponsePayload
    public VarsleVedtakSamordningResponse testQuery(@RequestPayload VarsleVedtakSamordning varsleVedtakSamordning) {
        ObjectFactory factory = new ObjectFactory();
        VarsleVedtakSamordningResponse test = factory.createVarsleVedtakSamordningResponse();
        test.setVarsleVedtakSamordningResponse("fnr: " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getGjelderFnr() + " " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getTpnr());

        return test;
    }
}

