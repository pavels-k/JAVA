public class Simulation {
    static Map map;
    static int countStep;

    public static void initActions(int countHerbivore, int countPredator) {
        map = new Map(countHerbivore, countPredator);
    }
    public static void renderMap() {
        for (int i = 0; i < map.M; i++) {
            for (int j = 0; j < map.N; j++) {
                System.out.print(map.getCellValue(i, j));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
//        Actions action = new Actions();

        int countHerbivore = 5;
        int countPredator = 3;
        initActions(countHerbivore, countPredator);
        renderMap();
    }
}
