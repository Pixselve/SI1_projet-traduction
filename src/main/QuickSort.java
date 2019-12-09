package main;

class QuickSort {


  /**
   * Sort multiples array using QuickSort
   *
   * @param arrays The arrays we want to sort with, at index 0, the array of reference
   */
  static void quickSort(String[]... arrays) {
    if (arrays.length < 1) throw new Error("You must pass at least one array to the function");
    quickSort(0, arrays[0].length - 1, arrays);
  }


  /**
   * @param lowIndex  The low index of the sorting area
   * @param highIndex The high index of the sorting area
   * @param arrays    The arrays we want to sort with, at index 0, the array of reference
   */
  private static void quickSort(int lowIndex, int highIndex, String[]... arrays) {

    if (arrays[0].length <= 1 || lowIndex >= highIndex) return;

//    We choose the pivot as the middle value of the array
    String pivot = arrays[0][lowIndex + (highIndex - lowIndex) / 2];

    int lowerScanner = lowIndex;
    int upperScanner = highIndex;

    while (lowerScanner <= upperScanner) {
// We search a value which is lower to the pivot
      while (arrays[0][lowerScanner].compareTo(pivot) < 0) {
        lowerScanner++;
      }
// We search a value which is higher to the pivot
      while (arrays[0][upperScanner].compareTo(pivot) > 0) {
        upperScanner--;
      }


      if (lowerScanner <= upperScanner) {
        switchValuesInArray(lowerScanner, upperScanner, arrays);
        lowerScanner++;
        upperScanner--;
      }


    }
    quickSort(lowIndex, upperScanner, arrays);
    quickSort(lowerScanner, highIndex, arrays);
  }


  /**
   * Swap elements in array at specific indexes
   *
   * @param firstIndex  The index of the first element
   * @param secondIndex The index if the second element
   * @param arrays      The arrays in which we want to swap elements
   */
  private static void switchValuesInArray(int firstIndex, int secondIndex, String[]... arrays) {
    for (String[] array : arrays) {
      switchValuesInArray(array, firstIndex, secondIndex);
    }

  }

  /**
   * Swap elements in array at specific indexes
   *
   * @param arr         The arrays in which we want to swap elements
   * @param firstIndex  The index of the first element
   * @param secondIndex The index if the second element
   */
  private static void switchValuesInArray(String[] arr, int firstIndex, int secondIndex) {
    String cache = arr[firstIndex];
    arr[firstIndex] = arr[secondIndex];
    arr[secondIndex] = cache;
  }
}
