package main;

public class AssociationTable {
  private String[] keys;
  private String[] values;

  /**
   * @param str The array of string in the format : {KEY, VALUE}
   */
  AssociationTable(String[] str) {
    if (str.length % 2 != 0) throw new Error("We need to have the same number of ids and elements");
    keys = new String[str.length / 2];
    values = new String[str.length / 2];
    int count = 0;
    for (int i = 0; i < str.length; i += 2) {
      keys[count] = str[i];
      values[count] = str[i + 1];
      count++;
    }
    QuickSort.quickSort(keys, values);
  }

  AssociationTable() {
    this.keys = new String[0];
    this.values = new String[0];
  }

  /**
   * Add an element to the Association Table
   *
   * @param key   The key we want to add
   * @param value The value associated to the key we want to add
   * @return The Association Table
   */
  public AssociationTable addElement(String key, String value) {
    String[] resultKeys = new String[this.keys.length + 1];
    String[] resultValues = new String[this.values.length + 1];
    boolean add = false;
    for (int i = 0; i < resultKeys.length; i++) {
      if (!add) {
        if (i == keys.length || key.compareTo(keys[i]) < 0) {
          resultKeys[i] = key;
          resultValues[i] = value;
          add = true;
        } else {
          resultKeys[i] = keys[i];
          resultValues[i] = values[i];
        }
      } else {
        resultKeys[i] = keys[i - 1];
        resultValues[i] = values[i - 1];
      }
    }
    this.keys = resultKeys;
    this.values = resultValues;
    return this;
  }

  /**
   * Remove an element from the Association Table
   *
   * @param key The key of the element we want to remove
   * @return The Association Table
   */
  public AssociationTable removeElement(String key) {
//    Check if the key is present
    if (Search.advancedSearch(this.keys, key) < 0) {
      return this;
    }

    String[] resultKeys = new String[keys.length - 1];
    String[] resultValues = new String[keys.length - 1];
    boolean removed = false;
    for (int i = 0; i < keys.length; i++) {
      if (!removed) {
        if (keys[i].equals(key)) {
          removed = true;
        } else {
          resultKeys[i] = keys[i];
          resultValues[i] = values[i];
        }
      } else {
        resultKeys[i - 1] = keys[i];
        resultValues[i - 1] = values[i];
      }
    }
    keys = resultKeys;
    values = resultValues;
    return this;
  }


  /**
   * Get the value associated to a key is the Association Table by using standard search (See class Search)
   *
   * @param key The key of the element
   * @return The value associated to the key
   */
  String getElement(String key) {
    int searchIndex = Search.standardSearch(this.keys, key);
    return searchIndex >= 0 ? this.values[searchIndex] : key;
  }

  /**
   * Get the value associated to a key is the Association Table by using dichotomous search (See class Search)
   *
   * @param key The key of the element
   * @return The value associated to the key
   */
  String getElementAdvanced(String key) {
    int searchIndex = Search.advancedSearch(this.keys, key);
    return searchIndex >= 0 ? this.values[searchIndex] : key;
  }


  /**
   * @return The length of the Association Table
   */
  public int length() {
    return keys.length;
  }

  /**
   * @return The keys of the Association Table
   */
  public String[] getKeys() {
    return keys;
  }

  /**
   * @return The values of the Association Table
   */
  public String[] getValues() {
    return values;
  }
}
