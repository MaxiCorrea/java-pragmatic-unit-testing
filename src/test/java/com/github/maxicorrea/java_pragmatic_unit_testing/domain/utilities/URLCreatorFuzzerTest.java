package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import java.net.MalformedURLException;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

public class URLCreatorFuzzerTest {

    @FuzzTest
    public void fuzzTestIsValidURL(FuzzedDataProvider data)
            throws MalformedURLException {
        var server = data.consumeString(32);
        var document = data.consumeRemainingAsString();
        new URLCreator().create(server, document);
    }

}
