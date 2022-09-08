package com.gmail.jobstest18.jenkins.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTests {

    @Test
    void test00() {
        assertTrue(true);
    }

    @Test
    void test01() {
        assertTrue(false);
    }

    @Test
    void test02() {
        assertTrue(false);
    }

    @Test
    @Disabled("some reason")
    void test03() {
        assertTrue(true);
    }
}
