package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import java.util.HashMap;
import java.util.Map;

public class TimePool {

    private static Map<String, Time> times = new HashMap<>();

    public static Time get(byte hour, byte minute) {
        return times.computeIfAbsent(Time.key(hour, minute),
                k -> new Time(hour, minute));
    }

    static void reset() {
        times.clear();
    }
}
