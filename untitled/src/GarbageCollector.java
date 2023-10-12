public class GarbageCollector {

    private String name;

    public GarbageCollector(String name) {
        this.name = name;
    }

    public GarbageCollector() {
    }
    public static int count = 0;

    public static void main(String[] args) throws Throwable {
        for (int i = 0 ; i < 1000000; i++) {

            GarbageCollector cat = new GarbageCollector();
            cat = null;//вот здесь первый объект становится доступен сборщику мусора
        }
        System.out.println(count);
        System.out.println(count);
    }

    @Override
    protected void finalize() throws Throwable {
        count++;
        System.out.println("Объект GarbageCollector уничтожен!");
//        System.out.println(count);
    }
}