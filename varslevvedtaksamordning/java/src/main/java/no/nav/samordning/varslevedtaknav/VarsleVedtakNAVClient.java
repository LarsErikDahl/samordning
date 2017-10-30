package no.nav.samordning.varslevedtaknav;

import no.nav.elsam.tpsamordningvarsling.v1_0.VarsleVedtakNAV;
import no.nav.elsam.tpsamordningvarsling.v1_0.VarsleVedtakNAVReq;
import no.nav.elsam.tpsamordningvarsling.v1_0.VarsleVedtakNAVResponse;
import no.nav.samordning.lib.sto.sam.asbo.samordning.ASBOStoVarsleVedtakSamordningRequest;
import no.nav.samordning.varslevedtaksamordning.inf.VarsleVedtakSamordning;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class VarsleVedtakNAVClient extends WebServiceGatewaySupport {

    public VarsleVedtakNAVResponse varsleVedtakNAV (ASBOStoVarsleVedtakSamordningRequest varsleVedtakSamordningRequest) {
        VarsleVedtakNAVReq req = new VarsleVedtakNAVReq();
        req.setFnr(varsleVedtakSamordningRequest.getGjelderFnr());
        req.setSamordningsmeldingId(varsleVedtakSamordningRequest.getSamId());
        req.setTpnr(varsleVedtakSamordningRequest.getTpnr());


        VarsleVedtakNAV vvnreq = new VarsleVedtakNAV();
        vvnreq.setVarsleVedtakNAVReq(req);

        VarsleVedtakNAVResponse response = (VarsleVedtakNAVResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:3030", vvnreq);

        return response;
    }
}
