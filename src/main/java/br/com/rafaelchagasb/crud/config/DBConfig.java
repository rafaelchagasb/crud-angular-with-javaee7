package br.com.rafaelchagasb.crud.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Siva
 *
 */

@Singleton
@Startup
@DataSourceDefinition(
		name = "java:jboss/datasources/CrudAngularDS", 
	    className = "org.h2.jdbcx.JdbcDataSource", 
	    url = "jdbc:h2:mem:test"
	)
public class DBConfig {

}
