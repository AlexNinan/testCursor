package com.example.microtest;

/**
 * Verifies that the JVM can add 1 and 2 correctly.
 */
public final class AddOneAndTwoTest implements TestCase {
    @Override
    public String name() {
        return "1 + 2 should equal 3";
    }

    @Override
    public void run(TestContext context) {
        int result = 1 + 2;
        context.assertEquals(3, result, "Basic integer addition (1+2) failed");
    }
}
