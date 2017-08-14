package com.example.onlinestore.config;

import com.example.onlinestore.rest.OnlineStoreSetupApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ravipalakodeti on 8/13/17.
 */
@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(OnlineStoreSetupApi.class);
    }
}
