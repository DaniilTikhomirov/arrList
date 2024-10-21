package test;

import exeptions.OutIndex;
import list.IntArrayList;
import list.IntList;
import list.StringArrayList;
import list.StringList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntArrayListTest {
    private IntList list;

    @BeforeEach
    public void setUp() {
        list = new IntArrayList();
    }


    @Test
    public void testAdd() {
        list.add(1);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.remove(0);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        list.add(1);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        list.add(1);
        Assertions.assertTrue(list.contains(1));
    }

    @Test
    public void testSize() {
        list.add(1);
        list.add(1);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.add(1);
        Assertions.assertEquals(1, list.get(0));
    }

    @Test
    public void testAddIndex() {
        list.add(1);
        list.add(0, 2);
        Assertions.assertEquals(2, list.get(0));
    }

    @Test void testAddError() {
        Assertions.assertThrows(OutIndex.class, () -> list.add(0, 1));
    }

    @Test
    public void testRemoveError() {
        Assertions.assertThrows(OutIndex.class, () -> list.remove(0));
    }

    @Test
    public void testSetError() {
        Assertions.assertThrows(OutIndex.class, () -> list.set(0, 2));
    }

    @Test
    public void testGetError() {
        Assertions.assertThrows(OutIndex.class, () -> list.get(0));
    }


    @Test
    public void testIndexOf() {
        list.add(1);
        list.add(2);
        Assertions.assertEquals(0, list.indexOf(1));
    }

    @Test
    public void testIndexOfOut() {
        list.add(1);
        Assertions.assertEquals(-1, list.lastIndexOf(2));
    }

    @Test
    public void testLastIndexOf() {
        list.add(1);
        list.add(1);
        Assertions.assertEquals(1, list.lastIndexOf(1));
    }

    @Test
    public void testLastIndexOfOut() {
        list.add(1);
        Assertions.assertEquals(-1, list.lastIndexOf(2));
    }

    @Test
    public void testEquals() {
        IntList list1 = new IntArrayList();
        list.add(1);
        list1.add(1);
        Assertions.assertTrue(list.equals(list1));
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        list.add(1);
        list.add(2);
        Integer[] array = list.toArray();
        Assertions.assertArrayEquals(new Integer[]{1, 2}, array);
    }

    @Test
    public void testSort() {
        list.add(2);
        list.add(3);
        list.add(1);
        list.sort();
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, list.toArray());
    }

    @Test
    public void testPasteSort() {
        list.add(2);
        list.add(3);
        list.add(1);
        list.sortPaste();
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, list.toArray());
    }
}
