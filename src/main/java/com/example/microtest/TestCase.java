package com.example.microtest;

/**
 * Represents a single executable test case.
 */
public interface TestCase {
    /**
     * @return human readable test name.
     */
    String name();

    /**
     * Executes the test logic.
     *
     * @param context shared assertion helpers
     * @throws Exception if the test fails unexpectedly
     */
    void run(TestContext context) throws Exception;
}
