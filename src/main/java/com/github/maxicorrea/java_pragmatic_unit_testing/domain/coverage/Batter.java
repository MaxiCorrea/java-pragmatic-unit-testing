package com.github.maxicorrea.java_pragmatic_unit_testing.domain.coverage;

public class Batter {

    private int strikeCount;
    private int ballCount;

    public Batter() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void foul() {
        if (strikeCount < 2) {
            strikeCount++;
        }
    }

    public void ball() {
        ++ballCount;
    }

    public void strike() {
        strikeCount++;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public boolean isDone() {
        return struckOut() || walked();
    }

    private boolean struckOut() {
        return ballCount == 4;
    }

    private boolean walked() {
        return strikeCount == 3;
    }

}
