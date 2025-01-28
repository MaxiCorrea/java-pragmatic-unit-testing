package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

public class Customer {

    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(Customer customer) {
        this.id = customer.id;
        this.name = customer.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
