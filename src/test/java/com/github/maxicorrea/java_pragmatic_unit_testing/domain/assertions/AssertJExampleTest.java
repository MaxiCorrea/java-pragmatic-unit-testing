package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class AssertJExampleTest {

    @Test
    public void simpleListTests() {
        var names = List.of("Moe", "Larry", "Curly");
        assertThat(names).contains("Curly");
        assertThat(names).contains("Curly", "Moe");
        assertThat(names).anyMatch(name -> name.endsWith("y"));
        assertThat(names).allMatch(name -> name.length() < 6);
    }

}
