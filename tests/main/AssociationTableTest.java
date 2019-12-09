package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssociationTableTest {

  @Test
  void addElement() {
//    Test the length
    assertEquals(4, new AssociationTable()
        .addElement("key1", "value1")
        .addElement("key2", "value2")
        .addElement("key3", "value3")
        .addElement("key4", "value4")
        .length()
    );

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

  @Test
  void removeElement() {
    //    Test the length
    assertEquals(2,
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("bbbbb")
            .length()
    );
//    Remove an element not present
    assertArrayEquals(new String[]{"aaaaa", "bbbbb", "ccccc"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("qzodnjondzq").getKeys()
    );
    assertArrayEquals(new String[]{"value1", "value2", "value3"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("qzodnjondzq").getValues()
    );
//    Remove the first element of the array
    assertArrayEquals(new String[]{"bbbbb", "ccccc"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("aaaaa").getKeys()
    );
    assertArrayEquals(new String[]{"value2", "value3"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("aaaaa").getValues()
    );
//    Remove the middle element of the array
    assertArrayEquals(new String[]{"aaaaa", "ccccc"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("bbbbb").getKeys()
    );
    assertArrayEquals(new String[]{"value1", "value3"},
        new AssociationTable(new String[]{"aaaaa", "value1", "bbbbb", "value2", "ccccc", "value3"})
            .removeElement("bbbbb").getValues()
    );
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