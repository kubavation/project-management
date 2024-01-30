package com.durys.jakub.projectmanagement.cqrs;

public interface CommandGateway {
    <T extends Command<R>, R> R dispatch(T command);
}
