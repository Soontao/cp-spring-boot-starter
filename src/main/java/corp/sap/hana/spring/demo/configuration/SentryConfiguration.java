package corp.sap.hana.spring.demo.configuration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@Profile({ "sentry" })
public class SentryConfiguration {
	
	@Bean
	public HandlerExceptionResolver sentryExceptionResolver() {
	    return new io.sentry.spring.SentryExceptionResolver();
	}
	
	@Bean
	public ServletContextInitializer sentryServletContextInitializer() {
	    return new io.sentry.spring.SentryServletContextInitializer();
	}
	
}
