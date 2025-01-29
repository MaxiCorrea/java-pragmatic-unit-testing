package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class NameValidatorTest {

    NameValidator validator = new NameValidator();

    @Test
    void throwsWhenNameIsEmpty() {
        assertThrows(NameValidatorException.class, () -> validator.validate(""));
    }

    @Test
    void throwsWhenNameContainsMultipleCommas() {
        assertThrows(NameValidatorException.class, () -> validator.validate("Langr, Jeffrey,J."));
    }

    @Test
    void doesNotThrowWhenNoErrorsExist() {
        assertDoesNotThrow(() -> validator.validate("Langr, Jeffrey J."));
    }

}
