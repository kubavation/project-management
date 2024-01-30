package com.durys.jakub.projectmanagement.cqrs;

import com.durys.jakub.projectmanagement.cqrs.testmodels.TestCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringCommandGatewayTest {

    @Autowired
    private SpringCommandGateway springCommandGateway;

    @Test
    void shouldDispatchCommand() {

        var command = new TestCommand();

        Integer result = springCommandGateway.dispatch(command);

        assertEquals(1, result);
    }
}