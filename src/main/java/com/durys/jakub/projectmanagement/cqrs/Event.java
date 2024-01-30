package com.durys.jakub.projectmanagement.cqrs;

import java.time.Instant;
import java.util.UUID;

public interface Event {
    Instant at();
    UUID id();
}
