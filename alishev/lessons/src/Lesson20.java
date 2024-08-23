public class Lesson20 {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.setAge(40);
        human1.setName("eqwda");

        Human.description = "Nice";

        Human human2 = new Human("sdaw");t
    }
}

class Human {
    private String name;
    private int age;

    public static String description;

    public Human() {
        System.out.println("Привет из первого конструктора!");
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}