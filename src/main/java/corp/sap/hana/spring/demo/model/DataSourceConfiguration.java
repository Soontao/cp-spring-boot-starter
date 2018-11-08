package corp.sap.hana.spring.demo.model;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@Profile({ "hdb" })
public class DataSourceConfiguration {
	
	@Bean(destroyMethod="")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException
	{
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		
		DataSource ds = dataSourceLookup.getDataSource("java:comp/env/jdbc/DefaultDB");
				
		return ds;
	}
	
}
