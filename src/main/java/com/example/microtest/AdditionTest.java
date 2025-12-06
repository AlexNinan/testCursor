package com.example.microtest;

/**
 * Simple test case ensuring that the JVM can add integers correctly.
 */
public final class AdditionTest implements TestCase {
    @Override
    public String name() {
        return "1 + 1 should equal 2";
    }

    @Override
    public void run(TestContext context) {
        int result = 1 + 1;
        context.assertEquals(2, result, "Basic integer addition failed");
    }
}
