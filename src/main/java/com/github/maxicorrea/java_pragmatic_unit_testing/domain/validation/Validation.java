package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

public interface Validation {
    
    boolean isInvalid();

    String errorMessage();
}
