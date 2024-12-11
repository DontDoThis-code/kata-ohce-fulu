package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class OhceTest {
  private Ohce ohce;
  @Mock
  private ConsoleInteractor mockInteractor;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    ohce = new Ohce(mockInteractor);
  }
  @Test
  void testMainLoop() {
    /*
     TODO: check that given the following inputs:
      - hello
      - oto
     - quit

    The following messages are shown to the user:
     - olleh
     - oto
     - That was a palindrome!

    fail("TODO");*/

    // Arrange
    when(mockInteractor.readInput())
            .thenReturn("hello")
            .thenReturn("oto")
            .thenReturn("quit");

    // Act
    ohce.mainLoop();

    // Assert
    InOrder inOrder = inOrder(mockInteractor);
    ((InOrder) inOrder).verify(mockInteractor).printMessage("olleh");
    inOrder.verify(mockInteractor).printMessage("oto");
    inOrder.verify(mockInteractor).printMessage("That was a palindrome!");
  }
}
