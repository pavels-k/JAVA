public class Simulation {

    // инициализировать карту
    static Map map;
    static int countStep;

    public static void initActions(int countHerbivore, int countPredator, int countGrass, int countRock, int countTree) {
        map = new Map(countHerbivore, countPredator, countGrass, countRock, countTree);
    }

    public static Herbivore getHerbivore() {
        for (Creature creature : Map.mapObjects.values()) {
            if (creature instanceof Herbivore) {
                return (Herbivore) creature;
            }
        }
        return null;
    }

    // отрисовать карту
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

        int countGrass = 5;
        int countRock = 4;
        int countTree = 3;

        initActions(countHerbivore, countPredator, countGrass, countRock, countTree);
        renderMap();
        Herbivore herbivore = getHerbivore();
        System.out.println(herbivore.x);
        System.out.println(herbivore.y);
        herbivore.makeMove(map);
        System.out.println(herbivore.x);
        System.out.println(herbivore.y);
    }
}
