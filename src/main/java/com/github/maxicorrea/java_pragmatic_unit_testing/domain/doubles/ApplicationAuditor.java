package com.github.maxicorrea.java_pragmatic_unit_testing.domain.doubles;

public class ApplicationAuditor implements Auditor {

    @Override
    public void audit(String message) {
        System.out.println(message);
    }
    
}
