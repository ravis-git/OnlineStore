package com.example.onlinestore.repositories;

import com.example.onlinestore.model.OnlineStore;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ravipalakodeti on 8/13/17.
 */
public interface OnlineStoreRepository extends CrudRepository<OnlineStore, String> {

    OnlineStore findByStoreName(String storeName);
}
