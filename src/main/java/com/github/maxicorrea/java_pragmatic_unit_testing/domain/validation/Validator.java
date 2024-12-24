package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public List<String> validate(
            final List<Validation> validators) {
        List<String> errorMessages = new ArrayList<>();
        for (Validation each : validators)
            if (each.isInvalid())
                errorMessages.add(each.errorMessage());
        return errorMessages;
    }

}
