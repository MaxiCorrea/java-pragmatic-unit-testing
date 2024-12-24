package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

public class NameEmptyValidation implements Validation {

    private final String name;

    public NameEmptyValidation(String name) {
        this.name = name;
    }

    @Override
    public boolean isInvalid() {
        return name == null || name.trim().isEmpty();
    }

    @Override
    public String errorMessage() {
       return "Name is Empty";
    }
    
}
