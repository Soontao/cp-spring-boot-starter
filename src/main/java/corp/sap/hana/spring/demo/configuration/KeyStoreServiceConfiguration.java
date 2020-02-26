package corp.sap.hana.spring.demo.configuration;

import java.security.KeyStore;
import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sap.cloud.crypto.keystore.api.KeyStoreNotFoundException;
import com.sap.cloud.crypto.keystore.api.KeyStoreService;
import com.sap.cloud.crypto.keystore.api.KeyStoreServiceException;

@Configuration
public class KeyStoreServiceConfiguration {

	@Bean
	@Profile({ "neo" })
	public KeyStoreService keyStoreServiceNeo() throws NamingException {
		return (KeyStoreService) new InitialContext().lookup("java:comp/env/KeyStoreService");
	}
	
	@Bean
	@Profile({ "!neo" })
	public KeyStoreService keyStoreServiceDev() throws NamingException {
		return new KeyStoreService() {
			
			@Override
			public void invalidateCache() {
				
			}
			
			@Override
			public Set<String> getKeyStoreNames() {
				return new HashSet<String>();
			}
			
			@Override
			public KeyStore getKeyStore(String arg0, char[] arg1) throws KeyStoreServiceException, KeyStoreNotFoundException {
				return null;
			}
		};
	}

}
