package main;

import util.ACX;

import java.util.ArrayList;
import java.util.List;

public class Main {
  private static AssociationTable lexique = new AssociationTable(ACX.lectureFichierString("libs/frenchEnglish.txt"));
  private static AssociationTable racines = new AssociationTable(initRacines("libs/racines.txt"));

  /**
   * @param text The text we want to translate, word by word in an array
   * @return The translated text using standard search, word by word in an array
   * with english words when a translation exist in the lexique and in french when a translation is not found
   */
  public static String[] translate(String[] text) {
    String[] result = new String[text.length];
    for (int i = 0; i < text.length; i++) {
      result[i] = lexique.getElement(text[i]);
      if(result[i].equals("")) result[i] = text[i];
    }
    return result;
  }

  /**
   * @param filePath The path to the words roots file
   * @return the original word at pos i and its root at pos i+1
   */
  private static String[] initRacines(String filePath) {
    String[] lines = ACX.lectureFichierString(filePath);
    String[] result = new String[lines.length * 2];
    int count = 0;
    for (String line : lines) {
      String[] words = ACX.mots(line);
      result[count] = words[1];
      result[count + 1] = words[2];
      count += 2;
    }
    return result;
  }

  /**
   * Get all roots of a specific french word
   * @param word a word that you its roots
   * @return an int array of all index of roots of the word in the association table
   */
  public static int[] getAllRoots(String word) {
    List<Integer> list_index = new ArrayList<Integer>();
    int index = racines.getIndexElementAdvanced(word);
    if (index == -1) return list_index.stream().mapToInt(i -> i).toArray();
    list_index.add(index);
    int j = index;
    while (true) {
      j++;
      if (j > racines.getKeys().length) break;
      if (racines.getKeys()[j].equals(word)) {
        list_index.add(j);
      } else {
        break;
      }
    }
    j = index;
    while (true) {
      j--;
      if (j < 0) break;
      if (racines.getKeys()[j].equals(word)) {
        list_index.add(j);
      } else {
        break;
      }
    }
    return list_index.stream().mapToInt(i -> i).toArray();
  }

  /**
   * @param text The text we want to translate, word by word in an array
   * @return The translated text using standard search and roots, word by word in an array
   * with english words when a translation exist in the lexique and in french when a translation is not found
   */
  public static String[] translate2(String[] text) {
    String[] result = new String[text.length];
    for (int i = 0; i < text.length; i++) {
      int[] roots = getAllRoots(text[i]);
      result[i]=text[i];
      for (int j = 0; j < roots.length; j++) {
        if (!(lexique.getElement(racines.getValues()[roots[j]]).equals(""))) {
          result[i] = lexique.getElement(racines.getValues()[roots[j]]);
          break;
        }
      }
    }
    return result;
  }

  /**
   * @param text The text we want to translate, word by word in an array
   * @return The translated text using dichotomous search and roots, word by word in an array
   * with english words when a translation exist in the lexique and in french when a translation is not found
   */
  public static String[] translate3(String[] text) {
    String[] result = new String[text.length];
    for (int i = 0; i < text.length; i++) {
      int[] roots = getAllRoots(text[i]);
      result[i]=text[i];
      for (int j = 0; j < roots.length; j++) {
        if (!(lexique.getElementAdvanced(racines.getValues()[roots[j]]).equals(""))) {
          result[i] = lexique.getElementAdvanced(racines.getValues()[roots[j]]);
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ACX.interfaceTraduction("translate3");
  }
}