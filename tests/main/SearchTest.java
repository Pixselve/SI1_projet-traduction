package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

  // ########################### Standard Search #####################################

  @Test
  void standardSearch_T1() {
    //  Length = 0
    assertEquals(-1, Search.standardSearch(new String[]{}, "a"));
  }
  @Test
  void standardSearch_T2() {
    //  Length = 1, element in
    assertEquals(0, Search.standardSearch(new String[]{"a"}, "a"));
  }@Test
  void standardSearch_T3() {
    //  Length = 1, element out
    assertEquals(-1, Search.standardSearch(new String[]{"a"}, "b"));
  }
  @Test
  void standardSearch_T4() {
    //  Length = 2, element in, first
    assertEquals(0, Search.standardSearch(new String[]{"a", "B"}, "a"));
  }
  @Test
  void standardSearch_T5() {
    //  Length = 2, element in, last
    assertEquals(1, Search.standardSearch(new String[]{"a", "B"}, "b"));
  }
  @Test
  void standardSearch_T6() {
    //  Length = 2, element out, last
    assertEquals(-1, Search.standardSearch(new String[]{"a", "B"}, "c"));
  }
  @Test
  void standardSearch_T7() {
    //  Length = 3, element in, first
    assertEquals(0, Search.standardSearch(new String[]{"a", "b", "c"}, "a"));
  }
  @Test
  void standardSearch_T8() {
    //  Length = 3, element in, middle
    assertEquals(1, Search.standardSearch(new String[]{"a", "b", "c"}, "b"));
  }
  @Test
  void standardSearch_T9() {
    //  Length = 3, element in, last
    assertEquals(2, Search.standardSearch(new String[]{"a", "b", "c"}, "c"));
  }
  @Test
  void standardSearch_T10() {
    //  Length = 3, element out
    assertEquals(-1, Search.standardSearch(new String[]{"a", "b", "c"}, "d"));
    //  OTHER
  }
  @Test
  void standardSearch_T11() {
    //  Length = 5, element out
    assertEquals(-1, Search.standardSearch(new String[]{"a", "B", "C", "c", "d"}, "z"));
  }
  @Test
  void standardSearch_T12() {
    //  Length = 5, element in, middle
    assertEquals(2, Search.standardSearch(new String[]{"a", "B", "C", "c", "d"}, "c"));
  }

  // ########################### Advanced Search #####################################

  @Test
  void advancedSearch_T1() {
    //  Length = 0
    assertEquals(-1, Search.advancedSearch(new String[]{}, "a"));
  }
  @Test
  void advancedSearch_T2() {
    //  Length = 1, element in
    assertEquals(0, Search.advancedSearch(new String[]{"a"}, "a"));
  }@Test
  void advancedSearch_T3() {
    //  Length = 1, element out
    assertEquals(-1, Search.advancedSearch(new String[]{"a"}, "b"));
  }
  @Test
  void advancedSearch_T4() {
    //  Length = 2, element in, first
    assertEquals(0, Search.advancedSearch(new String[]{"a", "B"}, "a"));
  }
  @Test
  void advancedSearch_T5() {
    //  Length = 2, element in, last
    assertEquals(1, Search.advancedSearch(new String[]{"a", "B"}, "b"));
  }
  @Test
  void advancedSearch_T6() {
    //  Length = 2, element out, last
    assertEquals(-1, Search.advancedSearch(new String[]{"a", "B"}, "c"));
  }
  @Test
  void advancedSearch_T7() {
    //  Length = 3, element in, first
    assertEquals(0, Search.advancedSearch(new String[]{"a", "b", "c"}, "a"));
  }
  @Test
  void advancedSearch_T8() {
    //  Length = 3, element in, middle
    assertEquals(1, Search.advancedSearch(new String[]{"a", "b", "c"}, "b"));
  }
  @Test
  void advancedSearch_T9() {
    //  Length = 3, element in, last
    assertEquals(2, Search.advancedSearch(new String[]{"a", "b", "c"}, "c"));
  }
  @Test
  void advancedSearch_T10() {
    //  Length = 3, element out
    assertEquals(-1, Search.advancedSearch(new String[]{"a", "b", "c"}, "d"));
    //  OTHER
  }
  @Test
  void advancedSearch_T11() {
    //  Length = 5, element out
    assertEquals(-1, Search.advancedSearch(new String[]{"a", "B", "C", "c", "d"}, "z"));
  }
  @Test
  void advancedSearch_T12() {
    //  Length = 5, element in, middle
    assertEquals(2, Search.advancedSearch(new String[]{"a", "B", "C", "c", "d"}, "c"));
  }
}