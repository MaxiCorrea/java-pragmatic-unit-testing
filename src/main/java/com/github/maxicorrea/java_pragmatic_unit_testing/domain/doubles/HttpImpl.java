package com.github.maxicorrea.java_pragmatic_unit_testing.domain.doubles;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpImpl implements Http {
    @Override
    public String get(String url) {
        try {
            var request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            var httpResponse = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
