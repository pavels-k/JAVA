
public class ClassesAndObjects {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Рома";
        person1.age = 50;
        person1.speak();
        //System.out.println("Меня зовут " + " мне " + person1.age + " лет");
        Person person2 = new Person();
        person2.name = "Вова";
        person2.age = 20;
        //System.out.println("Меня зовут " + person2.name);
        person2.speak();

        int year1 = person1.calculateYearsToRetirement();
        int year2 = person2.calculateYearsToRetirement();
    }
}


class Person {
    String name;
    int age;

    int calculateYearsToRetirement(){
        int years = 65 - age;
        return years;
    }

    void speak(){
        System.out.println("Меня зовут " + name + ", мне " +age + " лет");
    }

    void sayHello(){
        System.out.println("Привет!");
    }
}