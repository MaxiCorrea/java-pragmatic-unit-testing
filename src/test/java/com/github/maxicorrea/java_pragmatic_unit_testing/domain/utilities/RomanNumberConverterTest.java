package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumberConverterTest {

    @ParameterizedTest
    @CsvSource({ "1,I", "2,II", "3,III", "10,X", "20,XX", "11,XI", "200, CC", "732, DCCXXXII", "2275, MMCCLXXV",
            "999, CMXCIX"
    })
    void convertAll(int arabic, String roman) {
        assertEquals(roman, new RomanNumberConverter().toRoman(arabic));
    }

}
