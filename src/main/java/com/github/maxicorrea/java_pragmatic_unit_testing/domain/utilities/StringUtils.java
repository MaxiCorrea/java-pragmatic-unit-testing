package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

public class StringUtils {
    
    public static String capitalize(String word) {
        if(word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

}
