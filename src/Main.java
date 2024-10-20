import list.IntArrayList;
import list.IntList;
import list.StringArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StringArrayList arr = new StringArrayList();
        arr.add("Hello");
        arr.add("World");
        arr.add("Java");
        arr.add("Python");
        arr.add("C");
        arr.add("C++");
        arr.add("C#");
        arr.add("C++");
        arr.add("C");
        arr.add("C++");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println(arr.size());
        arr.add(5, "Hi");
        arr.set(0, "World");
        arr.remove("Python");
        arr.remove(0);
        arr.add("World");
        System.out.println(arr.indexOf("World"));
        System.out.println(arr.lastIndexOf("World"));
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println(arr.size());
        arr.clear();
        arr.add("Hello");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println("---------------");
        IntList arr2 = new IntArrayList();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
        }
        arr2.add(2, 10);
        arr2.remove(2);
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
        }

        arr2.clear();
        System.out.println("--------");


//        Random random = new Random();
//        for (int i = 0; i < 100_000; i++) {
//            arr2.add(random.nextInt(1000));
//        }
//        long start = System.currentTimeMillis();
//        arr2.sort();
//        System.out.println(System.currentTimeMillis() - start);
//        arr2.clear();
//        for (int i = 0; i < 100_000; i++) {
//            arr2.add(random.nextInt(1000));
//        }
//        start = System.currentTimeMillis();
//        arr2.sortPaste();
//        System.out.println(System.currentTimeMillis() - start);
        arr2.clear();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);
        arr2.add(7);
        System.out.println(arr2.binarySearch(5));
    }
}
