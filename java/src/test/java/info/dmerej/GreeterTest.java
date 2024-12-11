package info.dmerej;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;


public class GreeterTest {
  private Greeter greeter;
  private SystemClock mockClock;

  @BeforeEach
  public void setUp() {
    mockClock = mock(SystemClock.class);
    greeter = new Greeter(mockClock);
  }
  @Test
  void nightlyGreeting() {
    // Assert that greeter says "Good night" when current hour is 0 (midnight)
    // Arrange: Set the time to 23 PM
    when(mockClock.getCurrentHour()).thenReturn(20);

    // Act: Call the method
    String result = greeter.greet();

    // Assert: Verify the greeting is correct
    assertEquals("Good night", result);
  }

  @Test
  void neverAsserts() {
    /* Assert that the assertion in greet() is never thrown, by checking all hours from 0 to 23 */
    for (int hour = 0; hour < 24; hour++) {
      try {
        when(mockClock.getCurrentHour()).thenReturn(hour);
        greeter.greet();
      } catch (AssertionError e) {
        fail("AssertionError thrown for hour: " + hour);
      }
    }
  }
}
