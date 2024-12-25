package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import java.util.ArrayList;
import java.util.List;

public class DestinationList {

    private final List<FixedLocation> locations;

    public DestinationList() {
        locations = new ArrayList<>();
    }

    public void add(FixedLocation location) {
        if(!locations.contains(location))
            locations.add(location);
    }

    public List<FixedLocation> getLocations() {
        return locations;
    }

}
