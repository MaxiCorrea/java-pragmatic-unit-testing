package com.github.maxicorrea.java_pragmatic_unit_testing.domain.coverage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BatterTest {

    private Batter batter;

    @BeforeEach
    public void setup() {
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

    @Test
    void whenStruckOut() {
        batter.strike();
        batter.strike();
        batter.strike();
        assertTrue(batter.isDone());
    }

    @Test
    void isDoneWithWalk() {
        for (var i = 0; i < 4; i++)
            batter.ball();
        assertTrue(batter.isDone());
    }

    @Test
    void isNotDoneWhenNeitherWalkNorStrikeout() {
        assertFalse(batter.isDone());
    }

}
