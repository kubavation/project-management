package com.durys.jakub.projectmanagement.cqrs;

interface CommandHandlerProvider {
    <T extends Command<R>, R> CommandHandler<T, R> findCommandHandlerFor(T command);
}
