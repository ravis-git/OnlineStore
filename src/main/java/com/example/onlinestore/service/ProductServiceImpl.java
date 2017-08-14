package com.example.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



/**
 * Created by ravipalakodeti on 8/13/17.
 */
@Slf4j
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    DiscoveryClient client;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void setupInitialProducts() {

        ServiceInstance productService = client.getInstances("product-service")
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("product service not found"));

        String url = productService.getUri().toString().concat("/api/products");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>("{{\n" +
                "  \"cost\": 9.99,\n" +
                "  \"description\": \"A joke that is original and inexpensive\",\n" +
                "  \"id\": \"e8d71a82-19d5-4bbf-b7d3-c51d0d654341\",\n" +
                "  \"inStock\": true,\n" +
                "  \"name\": \"Joke\",\n" +
                "  \"seller\": null,\n" +
                "  \"sku\": \"ORGNL\"\n" +
                "}}", headers);
        restTemplate.postForLocation(url, entity);

//        restTemplate.postForLocation(url, );
//        log.info("==>> Product created at: {}", procudtLocation);
        return;
    }
}
