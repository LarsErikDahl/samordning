package no.nav.samordning.testobject;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.concurrent.atomic.AtomicInteger;

@Endpoint
public class TestObjectEndpoint {
    public static final String NAMESPACE_URI = "http://nav.no/samordning/testobject";

    private final AtomicInteger counter = new AtomicInteger();

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTestObjectRequest")
    @ResponsePayload
    public GetTestObjectResponse getTestObject(@RequestPayload GetTestObjectRequest request) {
        GetTestObjectResponse response = new GetTestObjectResponse();

        TestObject object = new TestObject();
        object.setValue(request.getValue());
        object.setNumber(counter.incrementAndGet());
        response.setTestObject(object);
        return response;
    }
}
