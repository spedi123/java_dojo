public class Dog {
    private String name;
    private int age;
    private String hairColor;

    // constructor
    // notic no return type

    public Dog() {
        this.name = "Default";
        this.age = 5;
        this.hairColor = "brown";
    }

    public Dog(String name, int age, String hariColor) {
        this.name = name;
        this.age = age;
        this.hairColor = hariColor;
    }

    // methods
    public void bark() {
        System.out.println("bark bark my name is" + this.name);
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hariColor) {
        this.hairColor = hairColor;
    }
}