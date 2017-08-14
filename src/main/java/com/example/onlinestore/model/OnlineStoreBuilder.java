package com.example.onlinestore.model;

import com.example.onlinestore.model.exception.OnlineStoreCreationException;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by ravipalakodeti on 8/13/17.
 */
public class OnlineStoreBuilder {

    @FunctionalInterface
    public interface OnlineStoreSetter extends Consumer<OnlineStore>{}

    public static OnlineStore build(OnlineStoreSetter... onlineStoreSetters) {
        final OnlineStore onlineStore = new OnlineStore();

        Stream.of(onlineStoreSetters).forEach(
                os -> os.accept(onlineStore)
        );

        //validate the entity
        final boolean valid = (onlineStore.getStoreName() == null || onlineStore.getStoreName().isEmpty()
                               || onlineStore.getContact() == null || onlineStore.getContact().isEmpty())
                ? false : true;

        if(!valid) throw new OnlineStoreCreationException("Name & Contact required");

        return onlineStore;
    }
}
