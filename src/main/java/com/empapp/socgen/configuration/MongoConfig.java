package com.empapp.socgen.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.mongodb.MongoClient;

/**
 * Mongo DB configuration class enables to connect to given db, and the required
 * values is read from application properties file
 * 
 * @author sumedh
 *
 */
@Configuration
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String dbName;

	@Value("${spring.data.mongodb.port}")
	private int port;

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.username}")
	private String username;

	@Value("${spring.data.mongodb.password}")
	private String pwd;

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(host, port);
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.empapp.socgen";
	}
}