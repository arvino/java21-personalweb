package com.arvinozulka.web.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.Document;

@ApplicationScoped
public class MongoConfig {
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> contactCollection;
    
    @PostConstruct
    public void init() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("personalweb");
        contactCollection = database.getCollection("contact");
    }
    
    @PreDestroy
    public void cleanup() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
    
    public MongoCollection<Document> getContactCollection() {
        return contactCollection;
    }
}
