import static org.junit.Assert.assertArrayEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

/**
 * Sort using Quicksort.
 *
 * @author John Miller
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * this method is partition, which will shifts the values around the
   * array to be greater than or less than the pivot
   * 
   * @pre: values is a valid array of T type objects, order is a valid
   * implementation of the compare functional interface, and
   * beginning and end are correct indices within the bounds of 0 to values.length
   * - 1
   * 
   * @post: it returns the index of the properly placed pivot around which we can
   * recurse
   */
  public <T> int partition(Comparator<? super T> order, T[] values, int beginning, int end) {
    if (end - beginning < 1) {
      return -1;
    } else if (end - beginning == 1) {
      if (order.compare(values[end], values[beginning]) < 0) {
        T temp = values[end];
        values[end] = values[beginning];
        values[beginning] = temp;
        return end;
      }
    }
    Random rand = new Random();
    int pivot = rand.nextInt(end - beginning) + beginning;// getting the pivot as a random index of the array;
    T temp = values[beginning];// swapping the pivot to the front of the array
    values[beginning] = values[pivot];
    values[pivot] = temp;
    pivot = beginning;
    int lb = beginning + 1;
    int ub = end;
    int valsSorted = 0;// this is a vartiable to keep track of how many values I sort, so that I can
                       // properly sort the pivor to it's pace at the end
    while (lb <= ub) {
      if (order.compare(values[lb], values[pivot]) > 0) {
        T tp = values[ub];
        values[ub] = values[lb];
        values[lb] = tp;
        ub--;
        valsSorted++;
      } else {
        lb++;
      }
    }
    T temporary = values[end - valsSorted];
    values[end - valsSorted] = values[beginning];
    values[beginning] = temporary;// swapping the pivot to it's proper place
    return end - valsSorted;// as this is where the final resting place of our pivot is

  } // sort(T[], Comparator<? super T>

  /*
   * this is my implementation of Quicksort, which randomly selects a pivot,
   * shifts the values around the
   * array to be greater than or less than the pivot, and then recursively calls
   * the subarrays using the indices
   * around the correctly placed pivot
   * 
   * @pre: values is a valid array of T type objects, order is a valid
   * implementation of the compare functional interface, and
   * beginning and end are correct indices within the bounds of 0 to values.length
   * - 1
   * 
   * @post: returns a permutation of the values array
   */
  public <T> void QuickSort(T[] values, Comparator<? super T> order, int beginning, int end) {
    int partitioned = partition(order, values, beginning, end);
    if (partitioned != -1) {
      QuickSort(values, order, beginning, partitioned - 1);
      QuickSort(values, order, partitioned + 1, end);
    }
  }

  public <T> void sort(T[] values, Comparator<? super T> order) {
    QuickSort(values, order, 0, values.length - 1);
  }
}// class Quicksort
