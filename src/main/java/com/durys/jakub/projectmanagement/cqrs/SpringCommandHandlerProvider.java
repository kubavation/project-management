package com.durys.jakub.projectmanagement.cqrs;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


class SpringCommandHandlerProvider implements CommandHandlerProvider {

    private final ConfigurableListableBeanFactory factory;

    private final Map<Class<? extends Command<?>>, String> handlers = new HashMap<>();

    public SpringCommandHandlerProvider(ConfigurableListableBeanFactory factory) {
        this.factory = factory;
        initHandlers();
    }

    @Override
    public <T extends Command<R>, R> CommandHandler<T, R> findCommandHandlerFor(T command) {
        String handlerClass = handlers.get(command.getClass());
        return instantiate(handlerClass);
    }


    private void initHandlers() {

        factory.getBeansOfType(CommandHandler.class)
                .entrySet()
                .stream()
                .forEach(entry -> handlers.put(commandFrom(entry.getValue().getClass()), entry.getKey()));
    }

    private Class<? extends Command<?>> commandFrom(Class<? extends CommandHandler> handler) {

        Type[] handlerInterfaces = handler.getGenericInterfaces();

        for (Type t: handlerInterfaces) {
            if (t instanceof ParameterizedType pt) {
                return (Class<? extends Command<?>>) pt.getActualTypeArguments()[0];
            }
        }

        return null;
    }


    private <R, T extends Command<R>> CommandHandler<T, R> instantiate(String handlerClass) {
        return factory.getBean(handlerClass, CommandHandler.class);
    }

}
