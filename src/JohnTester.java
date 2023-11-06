import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class JohnTester extends SortTester {
    // CONSTRUCTOR/////////
    public JohnTester() {
        super();
        this.sorter = MillerJohnSort.SORTER;
    } // QuicksortTester()

    // TESTS//
    @Test
    public void similarStringTest() {
        Integer[] original = { 1, 6, 4 };
        Integer[] expected = { 1, 4, 6 };
        sorter.sort(original, (x, y) -> x.compareTo(y));
        assertArrayEquals(original, expected);
    }

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
} // orderedStringTest
