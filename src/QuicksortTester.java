import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Tests of Quicksort.
 */
public class QuicksortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public QuicksortTester() {
    super();
    this.sorter = Quicksort.SORTER;
  } // QuicksortTester()

  @Test
  public void similarStringTest() {
    String[] original = { "a", "c", "b", "d", "f", "e" };
    String[] expected = { "a", "b", "c", "d", "e", "f" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedStringTest

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest
} // class QuicksortTester
