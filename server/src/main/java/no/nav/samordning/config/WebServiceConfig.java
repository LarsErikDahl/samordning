package no.nav.samordning.config;

import no.nav.samordning.varslevedtakaap.VarsleVedtakAAPWSConfig;
import no.nav.samordning.varslevedtaksamordning.VarsleVedtakSamordningWSConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.ws.config.annotation.EnableWs;

@EnableWs
@Configuration
@Import({VarsleVedtakSamordningWSConfig.class, VarsleVedtakAAPWSConfig.class})
public class WebServiceConfig {

}
