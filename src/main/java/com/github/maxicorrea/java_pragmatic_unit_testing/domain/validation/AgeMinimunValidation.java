package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

public class AgeMinimunValidation implements Validation {

    private int age;

    public AgeMinimunValidation(int age) {
        this.age = age;
    }

    @Override
    public boolean isInvalid() {
        return age < 18;
    }

    @Override
    public String errorMessage() {
        return "Minor cannot fly unaccompanied";
    }

}
