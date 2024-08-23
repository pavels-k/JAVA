public class Lesson20 {
    public static void main(String[] args) {
        Human human1 = new Human("dswad", 2);
        Human human2 = new Human("Pavel", 22);
        human1.getAllFields();
        Human.description = "Nice";
        human2.getAllFields();


        System.out.println();

        System.out.println(Human.getDescription());

        System.out.println((Math.pow(2, 4)));
        System.out.println((Math.PI));

    }
}

class Human {
    private String name;
    private int age;

    private static int countPeople = 0;

    public static String description;



    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        countPeople++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getDescription() {
        return description;
    }

    public void getAllFields() {
        System.out.println(name + "," + age + "," + description);
    }

    public void printNUmberOfPeople() {
        System.out.println("Number of people is" + countPeople);
    }

//    public static void printAllFields() {
//        System.out.println(name);
//    }
}