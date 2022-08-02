public class Test {
    public static void main (String[] args) {
        System.out.println("Hello there");

        Dog dog1 = new Dog("Joon", 14,"white");
        Dog dog2 = new Dog("DOO", 1,"gold");

        System.out.println(dog1.getName());
        System.out.println(dog1.getAge());
        System.out.println(dog1.getHairColor());
        System.out.println(dog2.getName());
        System.out.println(dog2.getAge());
        System.out.println(dog2.getHairColor());

        dog1.bark();
    }
}