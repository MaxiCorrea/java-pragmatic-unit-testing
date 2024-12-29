package com.github.maxicorrea.java_pragmatic_unit_testing.domain.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class AddressRetriverTest {

    Http http = mock(Http.class);
    Auditor auditor = mock(Auditor.class);

    @Test
    void answersAppropriateAddressForValidCoordinates() {

        when(http.get(contains("lat=38.000000&lon=-104.000000"))).thenReturn("""
                {"address":{
                "house_number":"324",
                "road":"Main St",
                "city":"Anywhere",
                "state":"Colorado",
                "postcode":"81234",
                "country_code":"us"}}
                """);

        var retriever = new AddressRetriver(http, auditor);
        var address = retriever.retrieve(38, -104);

        assertEquals("324", address.house_number());
        assertEquals("Main St", address.road());
        assertEquals("Anywhere", address.city());
        assertEquals("Colorado", address.state());
        assertEquals("81234", address.postcode());
        verifyNoInteractions(auditor);
    }

    @Test
    void throwsWhenNotUSCountryCode() {
        when(http.get(anyString())).thenReturn("""
                {"address":{ "country_code":"not us"}}""");
        var retriever = new AddressRetriver(http, auditor);
        assertThrows(UnsupportedOperationException.class,
                () -> retriever.retrieve(1.0, -1.0));
        verify(auditor, times(1)).audit("Request for country code us");
    }

}
