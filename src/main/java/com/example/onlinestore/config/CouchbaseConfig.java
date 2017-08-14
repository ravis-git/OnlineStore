package com.example.onlinestore.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;


/**
 * Created by ravipalakodeti on 8/13/17.
 */
@Configuration
@Slf4j
@EnableCouchbaseRepositories(basePackages = "com.example.onlinestore.repositories")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.bucket.name}")
    private String bucketName;

    @Value("${couchbase.bucket.password}")
    private String password;

    @Value("${couchbase.bootstrap-hosts}")
    private String host;


    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(this.host);
    }

    @Override
    protected String getBucketName() {
        return this.bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return this.password;
    }
}
