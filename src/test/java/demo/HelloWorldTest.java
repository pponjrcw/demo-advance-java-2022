package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    @Test
    @DisplayName("Test Name")
    public void case01() {
        HelloWorld helloWorld = new HelloWorld();
        String actual_result = helloWorld.hi("TEST");
        assertEquals("Hello TEST",actual_result);
    }

    @Test
    public void case02() {
    }
}