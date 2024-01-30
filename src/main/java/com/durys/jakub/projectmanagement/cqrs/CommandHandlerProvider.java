package com.durys.jakub.projectmanagement.cqrs;

public interface CommandHandlerProvider {
    <T extends Command<R>, R> CommandHandler<T, R> findHandlerFor(T command);
}
