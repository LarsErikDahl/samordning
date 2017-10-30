package no.nav.samordning.config;

import no.nav.samordning.varslevedtaksamordning.VarsleVedtakWSConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.ws.config.annotation.EnableWs;

@EnableWs
@Configuration
@Import(VarsleVedtakWSConfig.class)
public class WebServiceConfig {

}
