package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions.Customer;

public class InMemoryDatabaseTest {

    @Test
    void objectCopiedWhenAddedToDatabase() {
        var db = new InMemoryDatabase();
        Customer customer = new Customer("1", "Smelt, Inc.");
        db.add(customer);
        var retrieved = db.data.get("1");
        assertNotSame(retrieved, customer);
    }

}
