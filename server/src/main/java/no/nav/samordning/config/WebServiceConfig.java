package no.nav.samordning.config;

import no.nav.samordning.testobject.TestObjectEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "testObject")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema testObjectSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TestObjectPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(TestObjectEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchema(testObjectSchema);
        return wsdl11Definition;
    }

    @Bean(name = "varsleVedtakSamordning")
    public Wsdl11Definition defaultWsdl11Definitionvvs() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/no/nav/inf/varsleVedtakSamordning.wsdl"));

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema testObjectSchema() {
        return new SimpleXsdSchema(new ClassPathResource("test.xsd"));
    }
}
