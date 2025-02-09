import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/*a tester of my own sorter
 * @Author: John Miller
 */
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

    /*
     * this is to test if we have an input of length 0. in my firat attemp at this
     * MP this gave a stack overflow, so I am
     * inserting ths test for good measure
     */
    @Test
    public void LengthZeroStringTest() {
        String[] original = {};
        String[] expected = {};
        sorter.sort(original, (x, y) -> x.compareTo(y));
        assertArrayEquals(original, expected);
    } // orderedStringTest
} // orderedStringTest
