package main;

import util.ACX;

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
   * @param text The text we want to translate, word by word in an array
   * @return The translated text using standard search and roots, word by word in an array
   * with english words when a translation exist in the lexique and in french when a translation is not found
   */
  public static String[] translate2(String[] text) {
    String[] result = new String[text.length];
    for (int i = 0; i < text.length; i++) {
      result[i] = lexique.getElement(racines.getElement(text[i]));
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
      String racine;
      String newRacine;
      do {
        newRacine = racines.getElementAdvanced(text[i]);
        racine = newRacine;
      } while (!newRacine.equals(racine));
      result[i] = lexique.getElementAdvanced(racines.getElementAdvanced(racine));
    }
    return result;
  }

  public static void main(String[] args) {
    ACX.interfaceTraduction("translate3");
  }
}