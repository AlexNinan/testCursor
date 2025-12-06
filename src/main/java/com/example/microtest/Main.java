package com.example.microtest;

/**
 * Entrypoint that wires the framework together and kicks off the sample test.
 */
public final class Main {
    public static void main(String[] args) {
        new TestRunner()
                .register(new AdditionTest())
                .runAll();
    }
}
