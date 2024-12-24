package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import java.util.Objects;

public class Location {

    enum Heading {
        NORTH, EAST, SOUTH, WEST
    };

    private int x;
    private int y;
    private Heading heading;

    public Location(int x, int y, Heading heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public void move(int distance) {
        switch (heading) {
            case NORTH -> y = y + distance;
            case EAST -> x = x + distance;
            case SOUTH -> y = y - distance;
            case WEST -> x = x - distance;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Heading getHeading() {
        return heading;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        return this.x == other.x && this.y == other.y || this.heading == other.heading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, heading);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", => " + heading + ')';
    }

}
