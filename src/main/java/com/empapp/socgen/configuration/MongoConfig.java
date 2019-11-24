package com.empapp.socgen.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

/**
 * Mongo DB configuration class enables to connect to given db, and the required
 * values is read from application properties file
 * 
 * @author sumedh
 *
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${app.dbName}")
	private String dbName;

	@Value("${app.dbPort}")
	private Long port;

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient("127.0.0.1", 27017);
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.empapp.socgen";
	}
}