package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import java.util.HashMap;
import java.util.Map;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions.Customer;

public class InMemoryDatabase {

    Map<String, Customer> data = new HashMap<>();

    public void add(Customer customer) {
        data.put(customer.getId(), new Customer(customer));
    }

}
