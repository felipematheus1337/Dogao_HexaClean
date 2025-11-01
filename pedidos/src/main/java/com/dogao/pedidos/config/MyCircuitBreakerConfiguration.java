package com.dogao.pedidos.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyCircuitBreakerConfiguration implements RegistryEventConsumer<CircuitBreaker> {

    private static final Logger log = LoggerFactory.getLogger(MyCircuitBreakerConfiguration.class);

    @Override
    public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
           entryAddedEvent.getAddedEntry()
                   .getEventPublisher()
                   .onStateTransition(event -> log.info(event.toString()));
    }

    @Override
    public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {

    }

    @Override
    public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

    }
}
