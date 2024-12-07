package spring_introduction;

public class Test1 {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.say();
        String s = "Ыыыыыы";
        System.out.println(s.getClass().getName());
    }
    public static String reverseString(String string) {
        //напишите тут ваш код
        return new StringBuilder(string).reverse().toString();
    }
}

