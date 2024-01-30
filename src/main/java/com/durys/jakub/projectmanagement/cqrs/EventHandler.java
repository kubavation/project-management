package com.durys.jakub.projectmanagement.cqrs;

public interface EventHandler<T extends Event> {
    void handle(T event);
}
