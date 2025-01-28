package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.util.Objects;

public class Card {

    private final int number;
    private final String label;

    public Card(int number, String label) {
        this.number = number;
        this.label = label;
    }

    public int getNumber() {
        return number;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != getClass()) return false;
        if(obj instanceof Card other) {
            return other.label.equals(this.label) &&
                   other.number == this.number;
        }
        return false;
    }
    
}
