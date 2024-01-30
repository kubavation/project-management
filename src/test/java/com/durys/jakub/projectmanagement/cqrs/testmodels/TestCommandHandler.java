package com.durys.jakub.projectmanagement.cqrs.testmodels;

import com.durys.jakub.projectmanagement.cqrs.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class TestCommandHandler implements CommandHandler<TestCommand, Integer> {

    @Override
    public Integer handle(TestCommand testCommand) {
        return 1;
    }
}