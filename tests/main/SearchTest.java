package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

  @Test
  void standardSearch() {
    //  Length = 0
    assertEquals(-1, Search.standardSearch(new String[]{}, "a"));
    //  Length = 1
    assertEquals(0, Search.standardSearch(new String[]{"a"}, "a"));
    assertEquals(-1, Search.standardSearch(new String[]{"a"}, "b"));
    //  Length = 2
    assertEquals(0, Search.standardSearch(new String[]{"a", "B"}, "a"));
    assertEquals(1, Search.standardSearch(new String[]{"a", "B"}, "b"));
    assertEquals(-1, Search.standardSearch(new String[]{"a", "B"}, "c"));
    //  Length = 3
    assertEquals(0, Search.standardSearch(new String[]{"a", "b", "c"}, "a"));
    assertEquals(1, Search.standardSearch(new String[]{"a", "b", "c"}, "b"));
    assertEquals(2, Search.standardSearch(new String[]{"a", "b", "c"}, "c"));
    assertEquals(-1, Search.standardSearch(new String[]{"a", "b", "c"}, "d"));
    //  OTHER
    assertEquals(-1, Search.standardSearch(new String[]{"a", "B", "C", "c", "d"}, "z"));
    assertEquals(2, Search.standardSearch(new String[]{"a", "B", "C", "c", "d"}, "c"));

  }

  @Test
  void advancedSearch() {
    //  Length = 0
    assertEquals(-1, Search.advancedSearch(new String[]{}, "a"));
    //  Length = 1
    assertEquals(0, Search.advancedSearch(new String[]{"a"}, "a"));
    assertEquals(-1, Search.advancedSearch(new String[]{"a"}, "b"));
    //  Length = 2
    assertEquals(0, Search.advancedSearch(new String[]{"a", "B"}, "a"));
    assertEquals(1, Search.advancedSearch(new String[]{"a", "B"}, "b"));
    assertEquals(-1, Search.advancedSearch(new String[]{"a", "B"}, "c"));
    //  Length = 3
    assertEquals(0, Search.advancedSearch(new String[]{"a", "b", "c"}, "a"));
    assertEquals(1, Search.advancedSearch(new String[]{"a", "b", "c"}, "b"));
    assertEquals(2, Search.advancedSearch(new String[]{"a", "b", "c"}, "c"));
    assertEquals(-1, Search.advancedSearch(new String[]{"a", "b", "c"}, "d"));
    //  OTHER
    assertEquals(-1, Search.advancedSearch(new String[]{"a", "B", "C", "c", "d"}, "z"));
    assertEquals(2, Search.advancedSearch(new String[]{"a", "B", "C", "c", "d"}, "c"));
  }
}