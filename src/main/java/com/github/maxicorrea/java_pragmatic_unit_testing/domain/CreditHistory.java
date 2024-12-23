package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import java.util.LinkedList;
import java.util.List;

public class CreditHistory {

    private final List<CreditRating> rating;

    public CreditHistory() {
        rating = new LinkedList<>();
    }

    public void add(
            final CreditRating rating) {
        this.rating.add(rating);
    }

    public int arithmeticMean() {
        if (rating.isEmpty())
            return 0;
        int sum = 0;
        for (CreditRating each : rating)
            sum += each.rating();
        return sum / rating.size();
    }

}
