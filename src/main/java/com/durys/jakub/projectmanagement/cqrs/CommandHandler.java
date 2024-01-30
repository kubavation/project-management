package com.durys.jakub.projectmanagement.cqrs;

public interface CommandHandler<T extends Command<R>, R> {
    R handle(T t);
}
