package com.durys.jakub.projectmanagement.cqrs;

public interface EventPublisher {
    <T extends Event> void publish(T event);
}
