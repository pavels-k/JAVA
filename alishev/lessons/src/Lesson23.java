public class Lesson23 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" my");
        sb.append(" friend");
        System.out.println(sb.toString());
        System.out.printf("This is a string, %s\n", "NICE");
        System.out.printf("String %10d\n", 10000);
        System.out.printf("String %.2f \n", 45.43245);
    }
}
// hello world