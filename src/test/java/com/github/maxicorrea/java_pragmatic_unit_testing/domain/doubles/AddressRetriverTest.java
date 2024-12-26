package com.github.maxicorrea.java_pragmatic_unit_testing.domain.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AddressRetriverTest {

    @Test
    void answersAppropriateAddressForValidCoordinates() {
        Http http = url -> {
            if (!url.contains("lat=38") || !url.contains("lon=-104")) {
                fail("url " + url + " does not contain correct params");
            }
            return """
                {"address":{
                "house_number":"324",
                "road":"Main St",
                "city":"Anywhere",
                "state":"Colorado",
                "postcode":"81234",
                "country_code":"us"}}
                """;
        };

        var retriever = new AddressRetriver(http);
        var address = retriever.retrieve(38, -104);

        assertEquals("324", address.house_number());
        assertEquals("Main St", address.road());
        assertEquals("Anywhere", address.city());
        assertEquals("Colorado", address.state());
        assertEquals("81234", address.postcode());
    }

    @Test
    void throwsWhenNotUSCountryCode() {
        Http http = url -> """
                {"address":{ "country_code":"not us"}}""";
        var retriever = new AddressRetriver(http);
        assertThrows(UnsupportedOperationException.class,
                () -> retriever.retrieve(1.0, -1.0));
    }

}
