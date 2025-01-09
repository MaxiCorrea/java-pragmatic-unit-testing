package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import java.net.MalformedURLException;
import java.net.URL;

public class URLCreator {

    public String create(String server, String document) throws MalformedURLException {
        if (isEmpty(document))
            return new URL(String.format("https://%s", server)).toString();
        return new URL(String.format("https://%s/%s", server, clean(document))).toString();
    }

    private boolean isEmpty(String document) {
        return document == null || document.trim().equals("");
    }

    private String clean(String document) {
        return document.charAt(0) == '/'
                ? document.substring(1)
                : document;
    }

}
