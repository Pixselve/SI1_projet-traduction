package main;

import main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void traduire() {
    assertArrayEquals(new String[]{"shoot dead", "rocket", "repent"}, Main.translate(new String[]{"fusiller", "fusée", "repent"}));
    assertArrayEquals(new String[]{}, Main.translate(new String[]{}));
    assertArrayEquals(new String[]{"relax"}, Main.translate(new String[]{"se relâcher"}));
    assertArrayEquals(new String[]{"sefzefzefzef"}, Main.translate(new String[]{"sefzefzefzef"}));
  }
  @Test
  void traduire2() {
    assertArrayEquals(new String[]{"shoot dead", "rocket", "repent"}, Main.translate(new String[]{"fusiller", "fusée", "repent"}));
    assertArrayEquals(new String[]{}, Main.translate(new String[]{}));
    assertArrayEquals(new String[]{"relax"}, Main.translate(new String[]{"se relâcher"}));
    assertArrayEquals(new String[]{"sefzefzefzef"}, Main.translate(new String[]{"sefzefzefzef"}));

    assertArrayEquals(new String[]{"make a contract", "make a contract"}, Main.translate2(new String[]{"contractèrent", "contracterions"}));
  }
}