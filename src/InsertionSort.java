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
   * this is a helper called insert, which helps abstract away the inserting of
   * values from the main call to sort. it will perform the inserting on the
   * indice givem, if it is out of place.
   */

  public <T> void insert(T[] vals, Comparator<? super T> order, int i, boolean sorted) {
    while (sorted == false) {
      if (order.compare(vals[i - 1], vals[i]) <= 0) {
        sorted = true;
      } else {
        int sortIndex = i - 1;
        int valInd = i;
        while (sortIndex >= 0) {
          if (order.compare(vals[sortIndex], vals[valInd]) > 0 && sortIndex == 0) {
            T temp = vals[valInd];
            for (int x = valInd; x > sortIndex; x--) {
              vals[x] = vals[x - 1];
            }
            vals[sortIndex] = temp;
            sortIndex = -1;
          } else if (order.compare(vals[sortIndex], vals[valInd]) <= 0) {
            T temp = vals[valInd];
            for (int x = valInd; x > sortIndex + 1; x--) {
              vals[x] = vals[x - 1];
            }
            vals[sortIndex + 1] = temp;
            sortIndex = -1;
          } else {
            sortIndex--;
          }
        }
      }
    }
  }

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
      insert(vals, order, i, sorted);
    }
  }
}
// class InsertionSort
