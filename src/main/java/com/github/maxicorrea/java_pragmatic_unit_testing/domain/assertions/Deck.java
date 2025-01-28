package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {

    static LinkedList<Card> newDeck() {
        LinkedList<Card> cards = new LinkedList<>();
        for (var i = 1; i <= 13; i++) {
            cards.add(new Card(i, "C"));
            cards.add(new Card(i, "D"));
            cards.add(new Card(i, "H"));
            cards.add(new Card(i, "S"));
        }
        return cards;
    }

    private LinkedList<Card> cards;

    public Deck() {
        this.cards = newDeck();
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.removeFirst();
    }

    public List<Card> remaining(){
        return cards;
    }

}
