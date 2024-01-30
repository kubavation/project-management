package com.durys.jakub.projectmanagement.cqrs;

import com.durys.jakub.projectmanagement.cqrs.testmodels.TestCommand;
import com.durys.jakub.projectmanagement.cqrs.testmodels.TestCommandHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringCommandHandlerProviderTest {


    @Autowired
    private SpringCommandHandlerProvider commandHandlerProvider;

    @Test
    void shouldFindCommandHandler() {

        var command = new TestCommand();

        CommandHandler<TestCommand, Integer> handler = commandHandlerProvider.findCommandHandlerFor(command);

        assertNotNull(handler);
        assertEquals(TestCommandHandler.class, handler.getClass());
    }

}


