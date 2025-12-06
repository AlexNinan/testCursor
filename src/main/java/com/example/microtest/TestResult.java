package com.example.microtest;

/**
 * Immutable data structure describing the outcome of a test case run.
 */
public record TestResult(String name, boolean passed, long durationMillis, String failureMessage) {
    static TestResult success(String name, long durationMillis) {
        return new TestResult(name, true, durationMillis, null);
    }

    static TestResult failure(String name, long durationMillis, String failureMessage) {
        return new TestResult(name, false, durationMillis, failureMessage);
    }
}
