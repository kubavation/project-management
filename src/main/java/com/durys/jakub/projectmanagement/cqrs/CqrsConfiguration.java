package com.durys.jakub.projectmanagement.cqrs;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CqrsConfiguration {

    @Bean
    CommandHandlerProvider commandHandlerProvider(ConfigurableListableBeanFactory factory) {
        return new SpringCommandHandlerProvider(factory);
    }

    @Bean
    CommandGateway commandGateway(CommandHandlerProvider commandHandlerProvider) {
        return new SpringCommandGateway(commandHandlerProvider);
    }
}
