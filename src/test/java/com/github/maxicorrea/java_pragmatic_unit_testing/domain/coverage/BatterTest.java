package com.github.maxicorrea.java_pragmatic_unit_testing.domain.coverage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BatterTest {

    private Batter batter;

    @BeforeEach
    public void setup() {
        System.out.println("init");
        batter = new Batter();
    }

    @Test
    void doesNotIncrementStrikesWhenAtTwo() {
        batter.strike();
        batter.strike();
        batter.foul();
        assertEquals(2, batter.strikeCount());
    }

    @Test
    void incrementsStrikesWhenLessThan2() {
        batter.strike();
        batter.foul();
        assertEquals(2, batter.strikeCount());
    }

}
