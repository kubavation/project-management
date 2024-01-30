package com.durys.jakub.projectmanagement.project.domain;

import com.durys.jakub.projectmanagement.common.DomainValidationException;

import java.util.Objects;
import java.util.UUID;

public record ProjectId(UUID value) {

    public ProjectId {
        if (Objects.isNull(value)) {
            throw new DomainValidationException("Project Id value cannot be empty");
        }
    }
}
