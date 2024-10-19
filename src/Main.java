import list.StringArrayList;

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
    }
}
