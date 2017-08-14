package com.example.onlinestore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

/**
 * Created by ravipalakodeti on 8/13/17.
 *
 * An online store should have a name and contact. Custom builder used for this
 */
@Getter
@Setter
@Accessors(chain = true)
public class OnlineStore {

    @Id
    private String storeName;
    private String contact;

    protected OnlineStore(){}

}
