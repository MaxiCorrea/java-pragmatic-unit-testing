package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private static final Validation PASSING_VALIDATION = new Validation() {
        @Override
        public boolean isInvalid() {
            return false;
        }

        @Override
        public String errorMessage() {
            return "";
        }
    };

    private static final Validation FAIL_VALIDATION = new Validation() {
        @Override
        public boolean isInvalid() {
            return true;
        }

        @Override
        public String errorMessage() {
            return "fail";
        }
    };

    @Test
    void returnEmptyListWhenAllValidationPassed() {
        assertEquals(Collections.EMPTY_LIST, new Validator().validate(List.of(PASSING_VALIDATION)));
    }

    @Test
    void returnListOfFailingValidationMessages() {
        assertEquals(List.of(FAIL_VALIDATION.errorMessage()),
                new Validator().validate(List.of(PASSING_VALIDATION, FAIL_VALIDATION)));
    }

}
