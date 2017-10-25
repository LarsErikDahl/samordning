package no.nav.samordning.testwsdl;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.concurrent.atomic.AtomicInteger;

@Endpoint
public class TestQueryEndpoint {

    private AtomicInteger integer = new AtomicInteger();

    private static final String NAMESPACE_URI = "http://nav.no/samordning/testWSDL";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "testrequest")
    @ResponsePayload
    public Testkeyvalueobject testQuery(@RequestPayload Testrequest testkeyvalueobject) {

        String message = "You sent: " + testkeyvalueobject.getMessage();
        ObjectFactory factory = new ObjectFactory();
        Testkeyvalueobject test = factory.createTestkeyvalueobject();
        test.setGreeting(message);
        test.setValue(integer.incrementAndGet());

        return test;
    }
}
