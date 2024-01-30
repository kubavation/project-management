package com.durys.jakub.projectmanagement.cqrs;

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

        CommandHandler<TestCommand, Void> handler = commandHandlerProvider.findCommandHandlerFor(command);

        assertNotNull(handler);
        assertEquals(TestCommandHandler.class, handler.getClass());
    }

}


class TestCommand implements Command<Void> {}

@Component
class TestCommandHandler implements CommandHandler<TestCommand, Void> {

    @Override
    public Void handle(TestCommand testCommand) {
        return null;
    }
}