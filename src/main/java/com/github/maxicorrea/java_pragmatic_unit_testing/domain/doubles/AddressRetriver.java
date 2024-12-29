package com.github.maxicorrea.java_pragmatic_unit_testing.domain.doubles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressRetriver {

    private static final String SERVER = "https://nominatim.openstreetmap.org";

    private final Http http;
    private final Auditor auditor;

    public AddressRetriver(Http http, Auditor auditor) {
        this.http = http;
        this.auditor = auditor;
    }

    public Address retrieve(double latitude, double longitude) {
        var locationParams = "lat=%.6f&lon=%.6f".formatted(latitude, longitude);
        var url = "%s/reverse?%s&format=json".formatted(SERVER, locationParams);
        var jsonResponse = get(url);
        if(jsonResponse == null) return null;
        var response = parseResponse(jsonResponse);
        var address = response.address();
        var country = address.country_code();
        if (!country.equals("us")) {
            auditor.audit("Request for country code: %s".formatted(country));
            throw new UnsupportedOperationException(
                    "intl addresses unsupported");
        }
        return address;
    }

    private String get(String url) {
        try{
            return http.get(url);
        } catch(Exception ex) {
            return null;
        }
    }

    private Response parseResponse(String jsonResponse) {
        try {
            var mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonResponse, Response.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
