package com.woniuxy.snailrestaurant.config;


import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;


import javax.annotation.Resource;

@Configuration
public class MongoConfig {

    @Resource
    private SimpleMongoClientDatabaseFactory mongoDbFactory;

    @Bean
    public GridFSBucket getGridFSBuckets() {
        MongoDatabase mongoDatabase = mongoDbFactory.getMongoDatabase();
        return GridFSBuckets.create(mongoDatabase);
    }
}
