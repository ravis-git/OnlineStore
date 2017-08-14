package com.example.onlinestore.service;

import com.example.onlinestore.model.OnlineStore;
import com.example.onlinestore.repositories.OnlineStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ravipalakodeti on 8/13/17.
 */
@Component
public class OnlineStoreServiceImpl implements OnlineStoreService {

    @Autowired
    OnlineStoreRepository repository;

    @Override
    public void createOnlineStore(OnlineStore onlineStore) {
        repository.save(onlineStore);
    }
}
