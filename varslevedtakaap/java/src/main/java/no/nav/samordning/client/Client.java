package no.nav.samordning.client;

import no.nav.samordning.tjenester.varslevedtakaap.v1.*;
import no.nav.samordning.tjenester.varslevedtakaap.v1.binding.VarsleVedtakAAPSamordningV1;
import no.nav.samordning.tjenester.varslevedtakaap.v1.meldinger.VarsleVedtakAAPSamordningRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.net.MalformedURLException;
import java.net.URL;

public class Client extends WebServiceGatewaySupport {

    public void varsleVedtakAAP() throws VarsleVedtakAAPSamordningFeilFeilISendingMsg, VarsleVedtakAAPSamordningFeilVedtakIdIkkeFunnetMsg, VarsleVedtakAAPSamordningFeilHentVedtakFeilerMsg, VarsleVedtakAAPSamordningFeilTpnrIkkeFunnetMsg, MalformedURLException {
        VarsleVedtakAAPSamordningV1 varsleVedtakAAPSamordning = new VarsleVedtakAAPSamordningV1(new URL("http://localhost:3070"));
        no.nav.samordning.tjenester.varslevedtakaap.v1.VarsleVedtakAAPSamordningV1 port = varsleVedtakAAPSamordning.getVarsleVedtakAAPSamordningV1Port();
        VarsleVedtakAAPSamordning payload = new VarsleVedtakAAPSamordning();
        VarsleVedtakAAPSamordningRequest req = new VarsleVedtakAAPSamordningRequest();
        req.setFnr("1fnr2");
        req.setVedtakID("3vid4");
        req.getTpnr().add("5tp16");
        req.getTpnr().add("7tp28");
        payload.setVarsleVedtakAAPSamordningRequest(req);
        port.varsleVedtakAAPSamordning(payload);
    }
}
