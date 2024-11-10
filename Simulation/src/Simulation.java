import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Simulation {

    public static final List<int[]> DIRECTIONS;

    static {
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});

        // Сделаем список неизменяемым и присвоим его константе
        DIRECTIONS = Collections.unmodifiableList(directions);
    }

    // инициализировать карту
    static Map map;
    static int countStep;


    public void nextTurn(){
        makeStep();
        makeAction();
    }

    public static void makeStep(){
        for (Creature creature : Map.mapObjects.values()){
            creature.makeMove(map);
        }
    }

    public static void makeAction(){
        for (Creature creature : Map.mapObjects.values()){
            if (creature instanceof Herbivore){
//                creature. // поесть травы
            }
        }
    }


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
//        Herbivore herbivore = getHerbivore();
//        System.out.println(herbivore.x);
//        System.out.println(herbivore.y);
//        herbivore.makeMove(map);
//        System.out.println(herbivore.x);
//        System.out.println(herbivore.y);
        makeStep();
//        System.out.println(herbivore.x);
//        System.out.println(herbivore.y);
        System.out.println();
        renderMap();

    }
}
