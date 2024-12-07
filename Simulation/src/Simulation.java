import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    public void nextTurn() {
        makeStep();
        makeAction();
    }

    public static void makeStep() {
        // Цикл по существам
        for (Entity entity : Map.mapObjects.values()) {
            Creature creature = null;
            if (entity instanceof Creature) {
                creature = (Creature) entity;
            } else {
                break;
            }
            creature.makeMove(map);

        }

    }

    public static void makeAction() {
        for (Entity entity : Map.mapObjects.values()) {
            Creature creature = null;
            if (entity instanceof Creature) {
                creature = (Creature) entity;
            } else {
                break;
            }

            int x = creature.x;
            int y = creature.y;

            // 1. Травоядное ест траву
            if (creature instanceof Herbivore) {
                for (int[] direction : DIRECTIONS) {
                    if (map.getCellValue(x + direction[0], y + direction[1]).equals('G')) {

                        map.setCellValue(x + direction[0], y + direction[1], " ");

                        Grass grass = (Grass) Map.getCreatureByCoordinates(x + direction[0], y + direction[1]);
                        creature.addHp(grass.getHeal());
                        grass = null;
                        break;
                    }
                }
            }

            // 2. Хищник атакует травоядного
            else if (creature instanceof Predator) {
                for (int[] direction : DIRECTIONS) {
                    if (map.getCellValue(x + direction[0], y + direction[1]).equals('H')) {
                        // вытяни травоядного
                        Herbivore herbivore = (Herbivore) Map.getCreatureByCoordinates(x + direction[0], y + direction[1]);
                        herbivore.takeDamage(20);
                        if (herbivore.getHp() <= 0) {
                            herbivore = null;
                            Map.removeEntity(herbivore.getId(), x, y);
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void initActions(int countHerbivore, int countPredator, int countGrass, int countRock, int countTree) {
        map = new Map(countHerbivore, countPredator, countGrass, countRock, countTree);
    }

    public static Herbivore getHerbivore() {
        for (Entity entity : Map.mapObjects.values()) {
            if (entity instanceof Herbivore) {
                return (Herbivore) entity;
            }
        }
        return null;
    }

    // отрисовать карту
    public static void renderMap() {
        for (int i = 0; i < map.M; i++) {
            System.out.print('=');
        }
        System.out.println('=');

        for (int i = 0; i < map.M; i++) {
            for (int j = 0; j < map.N; j++) {
                System.out.print(map.getCellValue(i, j));
            }
            System.out.println();
        }
        for (int i = 0; i < map.M; i++) {
            System.out.print('=');
        }
        System.out.println('=');
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

        makeStep();
        System.out.println();
        renderMap();


    }
}
