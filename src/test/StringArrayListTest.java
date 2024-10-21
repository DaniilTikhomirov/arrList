package test;

import exeptions.OutIndex;
import list.StringArrayList;
import list.StringList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringArrayListTest {
    private StringArrayList list;

    @BeforeEach
    public void setUp() {
        list = new StringArrayList();
    }


    @Test
    public void testAdd() {
        list.add("test");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void testRemove() {
        list.add("test");
        list.remove("test");
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        list.add("test");
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        list.add("test");
        Assertions.assertTrue(list.contains("test"));
    }

    @Test
    public void testSize() {
        list.add("test");
        list.add("test2");
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.add("test");
        Assertions.assertEquals("test", list.get(0));
    }

    @Test
    public void testAddIndex() {
        list.add("test0");
        list.add(0, "test1");
        Assertions.assertEquals("test1", list.get(0));
    }

    @Test void testAddError() {
        Assertions.assertThrows(OutIndex.class, () -> list.add(0, "test"));
    }

    @Test
    public void testRemoveError() {
        Assertions.assertThrows(OutIndex.class, () -> list.remove(0));
    }

    @Test
    public void testSetError() {
        Assertions.assertThrows(OutIndex.class, () -> list.set(0, "test"));
    }

    @Test
    public void testGetError() {
        Assertions.assertThrows(OutIndex.class, () -> list.get(0));
    }

    @Test
    public void testRemoveIndex() {
        list.add("test");
        list.add("test2");
        list.remove(0);
        Assertions.assertEquals("test2", list.get(0));
    }

    @Test
    public void testIndexOf() {
        list.add("test");
        list.add("test");
        Assertions.assertEquals(0, list.indexOf("test"));
    }

    @Test
    public void testIndexOfOut() {
        list.add("test");
        Assertions.assertEquals(-1, list.lastIndexOf("test2"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("test");
        list.add("test");
        Assertions.assertEquals(1, list.lastIndexOf("test"));
    }

    @Test
    public void testLastIndexOfOut() {
        list.add("test");
        Assertions.assertEquals(-1, list.lastIndexOf("test2"));
    }

    @Test
    public void testEquals() {
        StringList list1 = new StringArrayList();
        list.add("test");
        list1.add("test");
        Assertions.assertTrue(list.equals(list1));
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        list.add("test");
        list.add("test2");
        String[] array = list.toArray();
        Assertions.assertArrayEquals(new String[]{"test", "test2"}, array);
    }

}
