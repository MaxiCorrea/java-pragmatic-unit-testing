package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

public record Time(byte hour, byte minute) {

    static String key(byte hour, byte minute) {
        return String.format("%d:%d", hour, minute);
    }

    @Override
    public String toString() {
        return key(hour, minute);
    }

}
