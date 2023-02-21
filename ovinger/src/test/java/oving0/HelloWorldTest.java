package oving0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HelloWorldTest {
    
    private HelloWorld helloWorld;

    @BeforeEach
    public void setUp() {
        this.helloWorld = new HelloWorld();
    }

    @Test
    public void testHelloWorld() {
        assertEquals("Hello World!", this.helloWorld.getHelloWorld());
    }

    @Test
    public void testHelloWorldLength() {
        assertEquals(12, this.helloWorld.getHelloWorldLength());
    }
}
