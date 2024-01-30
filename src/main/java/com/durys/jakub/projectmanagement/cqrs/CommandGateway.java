package com.durys.jakub.projectmanagement.cqrs;

public interface CommandGateway {
    <T extends Command> void dispatch(T command);
}
