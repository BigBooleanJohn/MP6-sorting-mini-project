import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author John Miller
 */

public class InsertionSort implements Sorter {

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
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  /*
   * this is my implementation of InsertionSort. It will go through each index,
   * sorting the first two values and so on.
   * 
   * @Pre: T is a valid array, can be empty
   * 
   * @Post: returns a sorted permutation of T, that is, they have the same values
   */
  @Override
  public <T> void sort(T[] vals, Comparator<? super T> order) {
    for (int i = 1; i < vals.length; i++) {// for each index of the array
      boolean sorted = false;
      while (sorted == false) {
        if (order.compare(vals[i - 1], vals[i]) <= 0) {// if the value is greater than the one to it's left, it's
                                                       // already sorted
          sorted = true;
        } else {
          int sortIndex = i - 1;
          int valInd = i;
          while (sortIndex >= 0) {
            if (order.compare(vals[sortIndex], vals[valInd]) > 0 && sortIndex == 0) {// if the value belongs at the
                                                                                     // leftmost index of the array
              T temp = vals[valInd];// save this value, as it is about to be overwritten when shifting vals over
              for (int x = valInd; x > sortIndex; x--) {// shift over values to make room for the correctly placed value
                                                        // at valInd
                vals[x] = vals[x - 1];
              }
              vals[sortIndex] = temp;
              sortIndex = -1;// the vals have been sorted out
            } else if (order.compare(vals[sortIndex], vals[valInd]) <= 0) {// if the value is unsorted and belongs
                                                                           // somewhere in the middle of the array
              T temp = vals[valInd];// save this value, as it is about to be overwritten when shifting vals over
              for (int x = valInd; x > sortIndex + 1; x--) {// shift over values to make room for the correctly placed
                                                            // value at valInd
                vals[x] = vals[x - 1];
              }
              vals[sortIndex + 1] = temp;
              sortIndex = -1;// the vals have been sorted out
            } else {
              sortIndex--;
            }
          }
        }
      }
    }
  }
}
// class InsertionSort
