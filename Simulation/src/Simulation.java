import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    // А) Сделать шаг
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

    // Б) Сделать действие
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


            }

            // 2. Хищник атакует травоядного
            else if (creature instanceof Predator) {
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[0];
                    if (map.isValid(newX, newY)) {
                        if (map.getCellValue(newX, newY).equals('H')) {
                            // вытяни травоядного


                            Herbivore herbivore = (Herbivore) Map.getCreatureByCoordinates(newX, newY);
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
    }

    public static void initActions(int countHerbivore, int countPredator, int countGrass, int countRock,
                                   int countTree) {
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

    // просимулировать и отрендерить один ход
    public static void nextTurn() {
        Renderer.renderMap(map);
        makeStep();
        makeAction();

    }


    // запустить бесконечный цикл симуляции и рендеринга
    public void startSimulation() {

    }

    // приостановить бесконечный цикл симуляции и рендеринга
    public void pauseSimulation() {

    }


    public static void main(String[] args) {
//        Actions action = new Actions();

        int countHerbivore = 5;
        int countPredator = 3;

        int countGrass = 5;
        int countRock = 4;
        int countTree = 3;

        initActions(countHerbivore, countPredator, countGrass, countRock, countTree);


//        Scanner scanner = new Scanner();


        nextTurn();
        nextTurn();
        nextTurn();
        nextTurn();



    }
}
