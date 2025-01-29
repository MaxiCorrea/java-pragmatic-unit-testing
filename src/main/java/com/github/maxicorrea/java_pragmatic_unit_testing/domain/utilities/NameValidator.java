package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

public class NameValidator {

    long commaCount(String s) {
        return s.chars().filter((c) -> c == ',').count();
    }

    void validate(String name) {
        if (name.isEmpty() ||
                commaCount(name) > 1)
            throw new NameValidatorException();
    }

}
