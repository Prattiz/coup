package com.back.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoClient mongoClient() {
        System.out.println("mongo");
        return MongoClients.create(GetEnv.mongoUri());
    }
}