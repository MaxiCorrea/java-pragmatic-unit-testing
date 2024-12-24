package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void returnEmptyStringWhenEmpty() {
        assertEquals("", StringUtils.capitalize(""));
    }    

    @Test
    public void uppercaseSingleLetter() {
        assertEquals("A", StringUtils.capitalize("a"));
    }

    @Test
    public void uppercaseFirstLetterOfLowercaseWord() {
        assertEquals("Alpha", StringUtils.capitalize("alpha"));
    }

    @Test
    public void lowercaseRemainderOfLetter() {
        assertEquals("Omega", StringUtils.capitalize("OMEGA"));
    }

}
