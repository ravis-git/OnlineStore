package com.example.onlinestore.rest;

import com.example.onlinestore.model.OnlineStore;
import com.example.onlinestore.model.OnlineStoreBuilder;
import com.example.onlinestore.rest.responses.Create;
import com.example.onlinestore.service.OnlineStoreServiceImpl;
import com.example.onlinestore.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ravipalakodeti on 8/13/17.
 */
@Path("onlinestores")
@Slf4j
public class OnlineStoreSetupApi {

    @Autowired
    OnlineStoreServiceImpl onlineStoreService;

    @Autowired
    ProductServiceImpl productService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{storeName}")
    public Create createStore(@PathParam("storeName") String storeName) {
        log.info("===> Online Store activation started");
        final OnlineStore onlineStore = OnlineStoreBuilder.build(
                os -> {
                    os.setStoreName(storeName)
                      .setContact("B Ware");
                }
        );

        productService.setupInitialProducts();

        return Create.builder().responseCode(201)
                .resource("/".concat(onlineStore.getStoreName()))
                .creationTime(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()))
                .build();
    }

}
