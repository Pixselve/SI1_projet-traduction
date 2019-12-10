package main;

public class Search {
  /**
   * Perform a standard search (O(N) = N)
   * @param arr The array in which we want to search
   * @param el The element we want to search
   * @return The index of the searched element OR -1 if not present
   */
  public static int standardSearch(String[] arr, String el) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].toLowerCase().equals(el.toLowerCase())) return i;
    }
    return -1;
  }

  /**
   * Perform a dichotomous search (O(N) = log(N))
   * @param arr The array in which we want to search
   * @param el The element we want to search
   * @return The index of the searched element OR -1 if not present
   */
  public static int advancedSearch(String[] arr, String el) {
    if (arr.length == 0) return -1;
    int a = 0;
    int b = arr.length - 1;
    while (a < b) {
      int middle = (b - a) / 2 + a;
      if (b - a == 1) {
        if (arr[a].toLowerCase().equals(el.toLowerCase())) {
          return a;
        } else if (arr[b].toLowerCase().equals(el.toLowerCase())) {
          return b;
        } else {
          return -1;
        }
      }
      if (el.toLowerCase().compareTo(arr[middle].toLowerCase()) > 0) {
        a = middle;
      } else {
        b = middle;
      }
    }
    return el.toLowerCase().equals(arr[a]) ? a : -1;
  }
}
