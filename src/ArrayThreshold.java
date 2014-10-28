/**
 * Group 3
 * Thresholding
 * 10/28/2014
 * @authors jwhnter1@memphis.edu gpence@memphis.edu dinakadhim@gmail.com
 *          wsfaris@memphis.edu  msnccllr@memphis.edu
 */

import java.util.Scanner;

public class ArrayThreshold {
  public static void main(String[] args) {
    Scanner   input   = new Scanner(System.in);
    final int SIZE    = 100000;        // size of random array
    final int NUM_MAX = 100;           // max value of array elements
    int[]     rArray  = new int[SIZE]; // random array
    int[]     bigArray;                // only elements > threshold
    int       threshold;               // user-supplied threshold value

    // create a random array
    for (int i = 0; i < rArray.length; i++) {
      rArray[i] = (int) (Math.random() * NUM_MAX) + 1;
    }

    // pick a threshold value
    System.out.print("Select a threshold value (1-" + (NUM_MAX - 1) + "): ");
    threshold = input.nextInt();

    // put the values above the threshold into bigArray
    bigArray = getBigArray(rArray, threshold);

    // print the contents of bigArray
    System.out.print("{");
    for (int i = 0; i < bigArray.length; i++) {
      System.out.print(bigArray[i] + ",");
      // line wrapping
      if (i % 20 == 0) {
        System.out.println();
      }
    }
    System.out.println("}");

    System.out.println("Generated a new array of size " + bigArray.length);
  }

  /**
   * Generates a thresholded array
   * @param array     the array to select from
   * @param threshold values above this will be selected
   * @return          array with all values greater than the threshold
   */
  public static int[] getBigArray(int[] array, int threshold) {
    int   num = 0;    // number of values greater than the threshold
    int   j = 0;      // counter for the greater array
    int[] greater;    // all numbers greater than the threshold value

    // find out how many numbers are bigger than the threshold, and store this
    // as 'num'
    for (int i = 0; i < array.length; i++) {
      if (array[i] > threshold) {
        num++;
      }
    }

    // use 'num' to determine the size of the new array
    greater = new int[num];

    // insert the greater values into the new array
    for (int i = 0; i < array.length; i++) {
      if (array[i] > threshold) {
        // j keeps track of where we are in the new array
        greater[j] = array[i];
        j++;
      }
    }
    return greater;
  }
}
