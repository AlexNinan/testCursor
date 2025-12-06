package com.example.microtest;

/**
 * Provides assertion helpers to tests.
 */
public final class TestContext {
    void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " (expected=" + expected + ", actual=" + actual + ")");
        }
    }

    void assertEquals(int expected, int actual) {
        assertEquals(expected, actual, "Values are not equal");
    }
}
