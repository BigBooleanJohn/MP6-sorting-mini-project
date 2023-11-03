import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Tests of MergeSort.
 */
public class MergeSortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public MergeSortTester() {
    super();
    this.sorter = MergeSort.SORTER;
  } // MergeSortTester()

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
  public void similarStringTest() {
    String[] original = { "delte", "dalta", "dolto" };
    String[] expected = { "dalta", "delte", "dolto" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

} // class MergeSortTester
