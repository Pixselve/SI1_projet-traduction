package main;

import main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  // ########################### Traduire #####################################
  @Test
  void traduire_T1() {
    assertArrayEquals(new String[]{"shoot dead", "rocket", "repent"}, Main.translate(new String[]{"fusiller", "fusée", "repent"}));
  }

  @Test
  void traduire_T2() {
    assertArrayEquals(new String[]{}, Main.translate(new String[]{}));
  }

  @Test
  void traduire_T3() {
    assertArrayEquals(new String[]{"relax"}, Main.translate(new String[]{"se relâcher"}));
  }

  @Test
  void traduire_T4() {
    assertArrayEquals(new String[]{"sefzefzefzef"}, Main.translate(new String[]{"sefzefzefzef"}));
  }

  // ########################### Traduire 2 #####################################

  @Test
  void traduire2_T1() {
    assertArrayEquals(new String[]{"shoot dead", "rocket", "repent"}, Main.translate2(new String[]{"fusiller", "fusée", "repent"}));
  }

  @Test
  void traduire2_T2() {
    assertArrayEquals(new String[]{}, Main.translate2(new String[]{}));
  }

  @Test
  void traduire2_T3() {
    assertArrayEquals(new String[]{"se relâcher"}, Main.translate2(new String[]{"se relâcher"}));
  }

  @Test
  void traduire2_T4() {
    assertArrayEquals(new String[]{"sefzefzefzef"}, Main.translate2(new String[]{"sefzefzefzef"}));
  }

  @Test
  void traduire2_T5() {
    assertArrayEquals(new String[]{"make a contract", "make a contract"}, Main.translate2(new String[]{"contractèrent", "contracterions"}));
  }

  @Test
  void traduire2_T6() {
    assertArrayEquals(new String[]{"beautiful", "beautiful", "beautiful"}, Main.translate3(new String[]{"belle", "belles","beau"}));
  }

  // ########################### Traduire 3 #####################################

  @Test
  void traduire3_T1() {
    assertArrayEquals(new String[]{"shoot dead", "rocket", "repent"}, Main.translate3(new String[]{"fusiller", "fusée", "repent"}));
  }

  @Test
  void traduire3_T2() {
    assertArrayEquals(new String[]{}, Main.translate3(new String[]{}));
  }

  @Test
  void traduire3_T3() {
    assertArrayEquals(new String[]{"se relâcher"}, Main.translate3(new String[]{"se relâcher"}));
  }

  @Test
  void traduire3_T4() {
    assertArrayEquals(new String[]{"sefzefzefzef"}, Main.translate3(new String[]{"sefzefzefzef"}));
  }

  @Test
  void traduire3_T5() {
    assertArrayEquals(new String[]{"make a contract", "make a contract"}, Main.translate3(new String[]{"contractèrent", "contracterions"}));
  }

  @Test
  void traduire3_T6() {
    assertArrayEquals(new String[]{"beautiful", "beautiful", "beautiful"}, Main.translate3(new String[]{"belle", "belles","beau"}));
  }

  // ########################### GET ALL ROOTS #####################################

  @Test
  void getAllRoots_T1() {
    assertArrayEquals(new int[]{26521, 26522, 26523}, Main.getAllRoots("belle"));
  }

  @Test
  void getAllRoots_T2() {
    assertArrayEquals(new int[]{35895, 35896, 35897}, Main.getAllRoots("bénédictines"));
  }

  @Test
  void getAllRoots_T3() {
    assertArrayEquals(new int[]{65478, 65479}, Main.getAllRoots("culée"));
  }
}