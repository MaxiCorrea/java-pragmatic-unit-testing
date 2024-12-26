package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import java.util.ArrayList;
import java.util.List;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.Location.Heading;

public class DestinationList {

    private final List<FixedLocation> locations;

    public DestinationList() {
        locations = new ArrayList<>();
    }

    public void add(FixedLocation location) {
        if (!locations.contains(location))
            locations.add(location);
    }

    public List<FixedLocation> getLocations() {
        return locations;
    }

    public void moveLocationWithHeading(Heading heading, int x, int y) {
        List<FixedLocation> updated = new ArrayList<>();
        for (FixedLocation location : locations) {
            boolean match = location.heading().equals(heading);
            updated.add(match ? new FixedLocation(x, y, heading) : location);
        }
        locations.clear();
        locations.addAll(updated);
    }

    public void removeLocationsFurtherThan(int x, int y, int distance) {
        List<FixedLocation> updated = new ArrayList<>();
        for (FixedLocation location : locations)
            if (location.distanceFrom(x, y) < distance)
                updated.add(location);
        locations.clear();
        locations.addAll(updated);
    }

}
