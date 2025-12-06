package com.example.microtest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lightweight runner that executes registered test cases and reports the result to stdout.
 */
public final class TestRunner {
    private final List<TestCase> cases = new ArrayList<>();

    public TestRunner register(TestCase testCase) {
        cases.add(testCase);
        return this;
    }

    public List<TestResult> runAll() {
        if (cases.isEmpty()) {
            System.out.println("No tests registered.");
            return Collections.emptyList();
        }

        System.out.println("Running " + cases.size() + " test(s)...\n");
        List<TestResult> results = new ArrayList<>();
        for (TestCase testCase : cases) {
            results.add(execute(testCase));
        }
        summarize(results);
        return results;
    }

    private TestResult execute(TestCase testCase) {
        Instant start = Instant.now();
        TestContext context = new TestContext();
        try {
            testCase.run(context);
            long duration = Duration.between(start, Instant.now()).toMillis();
            System.out.println("✔ " + testCase.name());
            return TestResult.success(testCase.name(), duration);
        } catch (AssertionError ae) {
            long duration = Duration.between(start, Instant.now()).toMillis();
            System.out.println("✘ " + testCase.name());
            System.out.println("    Assertion failed: " + ae.getMessage());
            return TestResult.failure(testCase.name(), duration, ae.getMessage());
        } catch (Exception e) {
            long duration = Duration.between(start, Instant.now()).toMillis();
            System.out.println("✘ " + testCase.name());
            System.out.println("    Unexpected error: " + e.getMessage());
            return TestResult.failure(testCase.name(), duration, e.toString());
        }
    }

    private void summarize(List<TestResult> results) {
        long passed = results.stream().filter(TestResult::passed).count();
        long failed = results.size() - passed;
        System.out.println();
        System.out.println("Summary: " + passed + " passed, " + failed + " failed.");
        if (failed > 0) {
            System.out.println("Investigation needed for failing tests above.");
        }
    }
}
