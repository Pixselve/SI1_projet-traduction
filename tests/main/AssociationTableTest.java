package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssociationTableTest {

//  Test file

  // ########################### Add element #####################################

  @Test
  void addElement_T1() {
//    Test the length
    assertEquals(4, new AssociationTable()
            .addElement("key1", "value1")
            .addElement("key2", "value2")
            .addElement("key3", "value3")
            .addElement("key4", "value4")
            .length()
    );
  }

  @Test
  void addElement_T2() {
//    Add an element when the Association Table is empty
    assertArrayEquals(
            new String[]{"key1"},
            new AssociationTable()
                    .addElement("key1", "value1")
                    .getKeys()
    );
    assertArrayEquals(
            new String[]{"value1"},
            new AssociationTable()
                    .addElement("key1", "value1")
                    .getValues()
    );
  }
  @Test
  void addElement_T3() {
//    Add an element when the Association Table contains one element
    assertArrayEquals(
            new String[]{"key1", "key2"},
            new AssociationTable(
                    new String[]{"key1", "value1"})
                    .addElement("key2", "value2")
                    .getKeys()
    );
    assertArrayEquals(
            new String[]{"value1", "value2"},
            new AssociationTable(
                    new String[]{"key1", "value1"})
                    .addElement("key2", "value2")
                    .getValues()
    );
  }
  @Test
  void addElement_T4() {
//    Add an element when the Association Table contains one element greater than the one added
    assertArrayEquals(
            new String[]{"aaaaa", "bbbbb"},
            new AssociationTable(
                    new String[]{"bbbbb", "value1"})
                    .addElement("aaaaa", "value2")
                    .getKeys()
    );
    assertArrayEquals(
            new String[]{"value2", "value1"},
            new AssociationTable(
                    new String[]{"bbbbb", "value1"})
                    .addElement("aaaaa", "value2")
                    .getValues()
    );
  }
  @Test
  void addElement_T5() {
//    Add an element when the Association Table contains two element greater and lesser than the one added
    assertArrayEquals(
            new String[]{"aaaaa", "bbbbb", "ccccc"},
            new AssociationTable(
                    new String[]{"aaaaa", "value1", "ccccc", "value2"})
                    .addElement("bbbbb", "value3")
                    .getKeys()
    );
    assertArrayEquals(
            new String[]{"value1", "value3", "value2"},
            new AssociationTable(
                    new String[]{"aaaaa", "value1", "ccccc", "value2"})
                    .addElement("bbbbb", "value3")
                    .getValues()
    );
  }
  @Test
  void addElement_T6() {
//    Add an element when the Association Table contains one element lesser than the one added
    assertArrayEquals(
        new String[]{"aaaaa", "bbbbb", "ccccc"},
        new AssociationTable(
            new String[]{"aaaaa", "value1", "bbbbb", "value2"})
            .addElement("ccccc", "value3")
            .getKeys()
    );
    assertArrayEquals(
        new String[]{"value1", "value2", "value3"},
        new AssociationTable(
            new String[]{"aaaaa", "value1", "bbbbb", "value2"})
            .addElement("ccccc", "value3")
            .getValues()
    );
  }

  // ########################### Remove Element #####################################

  @Test
  void removeElement_T1() {
    //    Test the length
    assertEquals(2,
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("bbbbb")
                    .length()
    );
  }
  @Test
  void removeElement_T2() {
//    Remove an element not present
    assertArrayEquals(new String[]{"aaaaa", "bbbbb", "ccccc"},
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("qzodnjondzq").getKeys()
    );
    assertArrayEquals(new String[]{"value1", "value2", "value3"},
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("qzodnjondzq").getValues()
    );
  }
  @Test
  void removeElement_T3() {
//    Remove the first element of the array
    assertArrayEquals(new String[]{"bbbbb", "ccccc"},
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("aaaaa").getKeys()
    );
    assertArrayEquals(new String[]{"value2", "value3"},
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("aaaaa").getValues()
    );
  }
  @Test
  void removeElement_T4() {
//    Remove the middle element of the array
    assertArrayEquals(new String[]{"aaaaa", "ccccc"},
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("bbbbb").getKeys()
    );
    assertArrayEquals(new String[]{"value1", "value3"},
            new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
                    .removeElement("bbbbb").getValues()
    );
  }
  @Test
  void removeElement_T5() {
//    Remove the last element of the array
    assertArrayEquals(new String[]{"aaaaa", "bbbbb"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("ccccc").getKeys()
    );
    assertArrayEquals(new String[]{"value1", "value2"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("ccccc").getValues()
    );
  }
}
