import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author John Miller
 */

public class MillerJohnSort implements Sorter {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new InsertionSort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    MillerJohnSort() {
    }

    /*
     * this is my implementation of MillerJohnSort. essentially, I will be
     * performing one iteration
     * of Partition from the QuickSort function, and will then perform Mergesort
     * recursively on the rest of
     * the two sides of the array. I did NOT use chatGPT, I took what I understood
     * from the wiki
     * pedia article and tried my best, using what I had already written!
     * 
     * @Pre: T is a valid array, can be empty
     * 
     * @Post: returns a sorted permutation of T, that is, they have the same values
     */
    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        Quicksort qs = new Quicksort();
        MergeSort ms = new MergeSort();
        qs.partition(order, values, 0, values.length - 1);
        ms.sort(values, order);
    }
}// InsertionSort()
