package Java_3.Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static Java_3.Lesson6.App.returnArrayAfter4;
import static Java_3.Lesson6.App.checkArrayOn1or4;

public class AppTest {

  @ParameterizedTest
  @MethodSource("dataReturnArrayAfter4")
  public void testReturnArrayAfter4(int[] array, int[] result) {
      Assertions.assertArrayEquals(result, returnArrayAfter4(array));
  }

  @ParameterizedTest
  @MethodSource("dataReturnArrayAfter4Throws")
  public void testReturnArrayAfter4Throws(int[] array) {
      Assertions.assertThrows(RuntimeException.class, () -> returnArrayAfter4(array));
  }

    @ParameterizedTest
    @MethodSource("dataTestCheckArrayOn1or4")
    public void TestCheckArrayOn1or4(int[] arr, boolean result) {
        Assertions.assertEquals(result, checkArrayOn1or4(arr));
    }





  public static Stream<Arguments> dataReturnArrayAfter4() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(new int[]{3, 4, 2, 1, 3}, new int[]{2, 1, 3}));
    out.add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{}));
    out.add(Arguments.arguments(new int[]{4, 2, 1, 3, 5}, new int[]{2, 1, 3, 5}));
    out.add(Arguments.arguments(new int[]{3, 4, 2}, new int[]{2}));
    out.add(Arguments.arguments(new int[]{3, 7, 4, 6, 5}, new int[]{6, 5}));
    return out.stream();
  }

 public static Stream<Arguments> dataReturnArrayAfter4Throws() {
     List<Arguments> out = new ArrayList<>();
     out.add(Arguments.arguments(new int[]{0, 0, 0, 0}));
     out.add(Arguments.arguments(new int[]{1, 2, 3, 5}));
     out.add(Arguments.arguments(new int[]{}));
     return out.stream();
 }

    public static Stream<Arguments> dataTestCheckArrayOn1or4() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{4, 2, 1, 3, 5}, true));
        out.add(Arguments.arguments(new int[]{3, 4, 2}, true));
        out.add(Arguments.arguments(new int[]{1, 4, 1, 4}, true));
        out.add(Arguments.arguments(new int[]{3, 6, 2, 7, 3}, false));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 2, 2}, false));
        out.add(Arguments.arguments(new int[]{0, 0, 1, 0, 0}, true));
        out.add(Arguments.arguments(new int[]{}, false));
        out.add(Arguments.arguments(null, false));
        return out.stream();
    }
}
