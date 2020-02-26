package corp.sap.hana.spring.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecuirtyConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (this.env.acceptsProfiles("security")) {
			http.headers().frameOptions().sameOrigin();
			http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll().and().logout()
					.permitAll();
		} else {
			http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
			http.formLogin().disable();
		}
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("admin").password("password").roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}

}
