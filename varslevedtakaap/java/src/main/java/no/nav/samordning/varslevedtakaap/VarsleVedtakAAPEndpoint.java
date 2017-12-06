package no.nav.samordning.varslevedtakaap;

import no.nav.samordning.tjenester.varslevedtakaap.v1.ObjectFactory;
import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordning;
import no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordningResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VarsleVedtakAAPEndpoint {


    public static final String NAMESPACE_URI = "http://nav.no/samordning/tjenester/varslevedtakaap/v1";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "varsleVedtakAAPSamordning")
    @ResponsePayload
    public VarsleVedtakAAPSamordningResponse testQuery(@RequestPayload VarsleVedtakAAPSamordning varsleVedtakSamordning) {
        ObjectFactory factory = new ObjectFactory();
        VarsleVedtakAAPSamordningResponse test = factory.createVarsleVedtakAAPSamordningResponse();
        test.setVarsleVedtakAAPSamordningResponse("Test v1");

        return test;
    }
}

