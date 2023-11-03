import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author John Miller
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * this function will merge together two arrays, left and right, into the main
   * array, in a
   * sorted fashion.
   * 
   * @pre: left and right are valid arrays, can be empty. order is a valid
   * implementation of the abstract
   * compare method within the comparator class
   * 
   * @post: returns nothing
   */
  public <T> void merge(T[] values, T[] left, T[] right, Comparator<? super T> order) {
    int leftIndex = 0;
    int rightIndex = 0;
    int valsIndex = 0;
    while (leftIndex < left.length && rightIndex < right.length) {// while we have values in both arrays
      if (order.compare(left[leftIndex], right[rightIndex]) <= 0) {
        values[valsIndex] = left[leftIndex];
        valsIndex++;
        leftIndex++;
      } else {
        values[valsIndex] = right[rightIndex];
        valsIndex++;
        rightIndex++;
      }
    }
    if (rightIndex < right.length) {// in case any values are left over in the right array
      while (rightIndex < right.length) {
        values[valsIndex] = right[rightIndex];
        valsIndex++;
        rightIndex++;
      }
    }
    if (leftIndex < left.length) {// in case any values are left over in the left array
      while (leftIndex < left.length) {
        values[valsIndex] = left[leftIndex];
        valsIndex++;
        leftIndex++;
      }
    }
  }

  /*
   * this is my implementation of MergeSort. it is a divide-and-conquer algorithm
   * that will split the array
   * until it is just one value, and then merge them together in a recursive
   * manner
   * 
   * @Pre: T is a valid array, can be empty
   * 
   * @Post: returns a sorted permutation of T, that is, they have the same values
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {

    if (values.length == 1) {
      return;
    }
    int middle = values.length / 2;
    T[] left = Arrays.copyOfRange(values, 0, middle);// grabbing values from 0(inclusive) to middle(exclusive)
    T[] right = Arrays.copyOfRange(values, middle, values.length);// grabbing values from middle(inclusive) to
                                                                  // end(exclusive)
    sort(left, order);//recursive call to sort the left array
    sort(right, order);//recursive call to sort the right array
    merge(values, left, right, order);//call to merge the arrays

  } // sort(T[], Comparator<? super T>
} // class MergeSort
