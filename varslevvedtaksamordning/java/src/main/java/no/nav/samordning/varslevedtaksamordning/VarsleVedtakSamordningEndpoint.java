package no.nav.samordning.varslevedtaksamordning;

import no.nav.samordning.varslevedtaknav.VarsleVedtakNAVClient;
import no.nav.samordning.varslevedtaksamordning.inf.ObjectFactory;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordning;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordningResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class VarsleVedtakSamordningEndpoint {
    public static final String NAMESPACE_URI = "http://nav.no/samordning/varslevedtaksamordning/inf";

    @Autowired
    VarsleVedtakNAVClient client;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "varsleVedtakSamordning")
    @ResponsePayload
    public VarsleVedtakSamordningResponse testQuery(@RequestPayload VarsleVedtakSamordning varsleVedtakSamordning) {
        ObjectFactory factory = new ObjectFactory();
        client.varsleVedtakNAV(varsleVedtakSamordning.getVarsleVedtakSamordningRequest());
        VarsleVedtakSamordningResponse test = factory.createVarsleVedtakSamordningResponse();
        test.setVarsleVedtakSamordningResponse("fnr: " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getGjelderFnr() + " " + varsleVedtakSamordning.getVarsleVedtakSamordningRequest().getTpnr());

        return test;
    }
}

