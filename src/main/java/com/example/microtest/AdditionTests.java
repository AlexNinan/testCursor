package com.example.microtest;

import java.util.List;

/**
 * Houses multiple addition-focused test cases so they live in one file.
 */
public final class AdditionTests {
    private AdditionTests() {
    }

    public static List<TestCase> all() {
        return List.of(new OnePlusOne(), new OnePlusTwo());
    }

    private static final class OnePlusOne implements TestCase {
        @Override
        public String name() {
            return "1 + 1 should equal 2";
        }

        @Override
        public void run(TestContext context) {
            int result = 1 + 1;
            context.assertEquals(2, result, "Basic integer addition (1+1) failed");
        }
    }

    private static final class OnePlusTwo implements TestCase {
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
}
