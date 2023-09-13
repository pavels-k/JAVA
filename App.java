


public class App {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(25));
    }

    // END
}


public static class Pair{
    int x, y;
    public void swap(){
        int xor = x ^ y;
        x = xor & y;
        y = xor & x;
    }
}