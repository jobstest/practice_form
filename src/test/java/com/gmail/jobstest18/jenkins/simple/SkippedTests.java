package com.gmail.jobstest18.jenkins.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {

    @Test
    @Disabled
    void test00() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test01() {
        assertTrue(false);
    }

    @Test
    @Disabled
    void test02() {
        assertTrue(false);
    }

    @Test
    @Disabled("some reason")
    void test03() {
        assertTrue(true);
    }
}
