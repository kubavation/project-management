package com.durys.jakub.projectmanagement.cqrs;

class SpringCommandGateway implements CommandGateway {

    private final CommandHandlerProvider commandHandlerProvider;

    SpringCommandGateway(CommandHandlerProvider commandHandlerProvider) {
        this.commandHandlerProvider = commandHandlerProvider;
    }

    @Override
    public <T extends Command<R>, R> R dispatch(T command) {
        CommandHandler<T, R> commandHandler = commandHandlerProvider.findCommandHandlerFor(command);
        return commandHandler.handle(command);
    }
}
