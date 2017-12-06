package no.nav.samordning.varslevedtaksamordning;

import nav_cons_sto_sam_samordning.no.nav.inf.ObjectFactory;
import nav_cons_sto_sam_samordning.no.nav.inf.VarsleVedtakSamordning;
import nav_cons_sto_sam_samordning.no.nav.inf.VarsleVedtakSamordningResponse;
import no.nav.samordning.varslevedtaknav.VarsleVedtakNAVClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class VarsleVedtakSamordningEndpoint {
    public static final String NAMESPACE_URI = "http://nav-cons-sto-sam-samordning/no/nav/inf";

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

