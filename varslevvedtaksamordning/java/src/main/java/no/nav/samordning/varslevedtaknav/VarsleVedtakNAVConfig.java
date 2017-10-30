package no.nav.samordning.varslevedtaknav;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class VarsleVedtakNAVConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("no.nav.elsam.tpsamordningvarsling.v1_0");
        return marshaller;
    }

    @Bean
    public VarsleVedtakNAVClient varsleVedtakNAVClient(Jaxb2Marshaller marshaller) {
        VarsleVedtakNAVClient client = new VarsleVedtakNAVClient();
        client.setDefaultUri("http://localhost:3030");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
