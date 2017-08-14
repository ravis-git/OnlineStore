package com.example.onlinestore.rest.responses;

import lombok.Builder;
import lombok.Setter;

/**
 * Created by ravipalakodeti on 8/12/17.
 */
@Builder
@Setter
public class Create {

    public int responseCode;
    public String resource;
    public String creationTime;
}
