package com.marcos.employee.Employesr2dbc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;


@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.marcos.employee.Employesr2dbc.repository")
public class DataConnection extends AbstractReactiveMongoConfiguration {
	
	@Value("${port}")
    private String port;
     
    @Value("${dbname}")
    private String dbName;

	@Override
	protected String getDatabaseName() {
		return this.dbName;
	}
	
	/*Creates a new client with the default connection string "mongodb://localhost"*/
	@Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
	
	/* It simplifies the use of Reactive MongoDB usage and helps to avoid common errors, usa BSON*/
	@Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

	

}
