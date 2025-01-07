package com.github.maxicorrea.java_pragmatic_unit_testing.domain.threading;

import java.util.ArrayList;
import java.util.List;

public class Criteria {
    
    private List<Criterion> criterions;
    
    public Criteria() {
        criterions = new ArrayList<>();
    }

    public void add(Criterion criterion) {
        criterions.add(criterion);
    }

}
