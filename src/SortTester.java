import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+
  /*
   * NOTE: this is a bank of tests that I have written to test my different sort
   * methods. This
   * file does not test them, but simply contains them
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void sameStringTest() {
    String[] original = { "delta", "delta", "delta" };
    String[] expected = { "delta", "delta", "delta" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void emptyStringTest() {
    String[] original = { "", "", "" };
    String[] expected = { "", "", "" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void similarStringTest() {
    String[] original = { "delte", "dalta", "dolto" };
    String[] expected = { "dalta", "delte", "dolto" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void nullStringTest() {
    String[] original = { null, null, null };
    String[] expected = { null, null, null };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void mixedStringTest() {
    String[] original = { "", null, "delta" };
    String[] expected = { "delta", "", null };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest
} // class SortTester
