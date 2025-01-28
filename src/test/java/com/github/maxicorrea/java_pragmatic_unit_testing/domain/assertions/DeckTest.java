package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void hasBeenShuffled() {
        var cards = deck.remaining();
        assertNotEquals(Deck.newDeck(), cards);
    }

}
