public class Demo {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = cat1;
        // вставьте код сюда
        cat1 = new Cat("Роджер");
        System.out.println("Кот 1: " + cat1.name + ", кот 2: " + cat2.name);
    }
}

class Cat {
    String name;

    public Cat(String catName) {
        name = catName;
    }
}