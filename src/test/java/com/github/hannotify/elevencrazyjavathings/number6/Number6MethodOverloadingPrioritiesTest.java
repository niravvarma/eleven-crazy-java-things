package com.github.hannotify.elevencrazyjavathings.number6;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("#6 - Method overloading priorities are all over the place")
class Number6MethodOverloadingPrioritiesTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("printSum() should print 'In printSum(double)' when int arguments are passed, because widening is prioritised over boxing, which in turn is prioritised over varargs.")
    void printSumDouble() {
        int a = 32;
        int b = 10;

        Number6MethodOverloadingPriorities.printSum(a, b);

        assertThat(outputStreamCaptor.toString()).isEqualTo(
                String.format("In printSum(double): %f%n", (double) a + b));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}