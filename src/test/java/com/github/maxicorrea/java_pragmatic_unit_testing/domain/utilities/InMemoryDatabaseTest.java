package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions.Customer;

public class InMemoryDatabaseTest {

    private InMemoryDatabase db;

    @BeforeEach
    void createSut() {
        db = new InMemoryDatabase();
    }

    @Test
    void objectCopiedWhenAddedToDatabase() {
        Customer customer = new Customer("1", "Smelt, Inc.");
        db.add(customer);
        var retrieved = db.data.get("1");
        assertNotSame(retrieved, customer);
    }

    @Test
    void returnsCustomerCorrespondingToId() {
        var customer = new Customer("42", "Mr Creosote");
        db.add(customer);
        var retrieved = db.get("42");
        assertEquals(customer, retrieved);
    }

    @Test
    void returnsNotNullForNonexistentKey() {
        assertNull(db.get("42"));
    }

}
