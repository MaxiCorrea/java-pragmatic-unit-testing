package com.github.maxicorrea.java_pragmatic_unit_testing.domain.coverage;

public class Batter {

    private int strikeCount;

    public Batter() {
        strikeCount = 0;
    }

    public void foul() {
        if (strikeCount < 2) {
            strikeCount++;
        }
    }

    public void strike() {
        strikeCount++;
    }

    public int strikeCount() {
        return strikeCount;
    }

}
