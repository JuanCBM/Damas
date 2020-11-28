package usantatecla.draughts.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.BufferedReader;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleTest {

  @InjectMocks
  Console console;

  @Mock
  BufferedReader bufferedReader;

  @Test
  public void testReadStringWhenIOExceptionThenAskAgain() throws IOException {
    String expected = "Prueba OK";
    when(bufferedReader.readLine()).thenThrow(new IOException()).thenReturn(expected);
    console.readString("testReadStringWhenIOExceptionThenAskAgain");
    verify(bufferedReader, times(2)).readLine();
    assertEquals(expected, console.readString("testReadStringWhenIOExceptionThenAskAgain"));
  }

  @Test
  public void testReadNumberWhenNumberFormatExceptionThenAskAgain() throws IOException {
    String expected = "9999";
    when(bufferedReader.readLine()).thenReturn("xxxx", expected);
    int resultado = console.readInt("testReadNumberWhenNumberFormatExceptionThenAskAgain");
    verify(bufferedReader, times(2)).readLine();
    assertEquals(Integer.parseInt(expected), resultado);
  }

  @Test
  public void testReadCharWhenLongerThanOneThenAskAgain() throws IOException {
    char expected = 'y';
    when(bufferedReader.readLine()).thenReturn("xxxx", expected + "");
    char resultado = console.readChar("testReadCharWhenLongerThanOneThenAskAgain");
    verify(bufferedReader, times(2)).readLine();
    assertEquals(expected, resultado);
  }
}
