import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            Try {
                Integer castedValue = (Integer) myList.get(i);
            } catch(ClassCastException error) {
                System.out.println(error)
            }
        }
    }
}