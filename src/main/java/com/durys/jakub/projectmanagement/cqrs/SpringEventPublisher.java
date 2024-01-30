package com.durys.jakub.projectmanagement.cqrs;

import org.springframework.context.ApplicationEventPublisher;

class SpringEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @Override
    public <T extends Event> void publish(T event) {
        applicationEventPublisher.publishEvent(event);
    }
}
