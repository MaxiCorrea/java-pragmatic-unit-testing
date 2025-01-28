package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.util.Objects;

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


    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != getClass()) return false;
        if(obj instanceof Customer other) {
            return other.name.equals(this.name) &&
                   other.id.equals(this.id);
        }
        return false;
    }

}
