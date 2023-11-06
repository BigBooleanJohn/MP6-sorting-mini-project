import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Tests of InsertionSort.
 */
public class InsertionSortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public InsertionSortTester() {
    super();
    this.sorter = InsertionSort.SORTER;
  } // InsertionSortTester()

  @Test
  public void similarStringTest() {
    String[] original = { "delte", "dalta", "dolto" };
    String[] expected = { "dalta", "delte", "dolto" };
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
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

} // class InsertionSortTester
