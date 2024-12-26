package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.Location.Heading;

public record FixedLocation(int x, int y, Heading heading) {
    public FixedLocation move(int distance) {
        return switch (heading) {
            case NORTH -> new FixedLocation(x, y + distance, Heading.NORTH);
            case EAST -> new FixedLocation(x + distance, y, Heading.EAST);
            case SOUTH -> new FixedLocation(x, y - distance, Heading.SOUTH);
            case WEST -> new FixedLocation(x - distance, y, Heading.WEST);
        };
    }

    public double distanceFrom(int x, int y) {
        return Math.sqrt(
                Math.pow(x - this.x(), 2) + Math.pow(y - this.y(), 2));
    }

}
