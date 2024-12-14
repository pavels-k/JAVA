import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

public class Simulation {

    public static final List<int[]> DIRECTIONS;

    static {

        // Сделаем список неизменяемым и присвоим его константе
        DIRECTIONS = List.of(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});
    }

    // инициализировать карту
    static Map map;


    // А) Сделать шаг
    public static void makeStep() {
        // Цикл по существам
        System.out.println(Map.mapObjects);
        Collection<Entity> values = Map.mapObjects.values();
        for (Entity entity :values) {

            Creature creature = null;
            if (entity instanceof Creature) {
                creature = (Creature) entity;
                creature.makeMove(map);
            }
        }
    }

    // Б) Сделать действие
    public static void makeAction() {
        for (Entity entity : Map.mapObjects.values()) {
            Creature creature = null;
            if (entity instanceof Creature) {
                creature = (Creature) entity;
            }


            // 1. Травоядное ест траву
            if (creature instanceof Herbivore) {
                creature.doAction(map);

            }
            // 2. Хищник атакует травоядного
            else if (creature instanceof Predator) {
                creature.doAction(map);
            }


        }
    }

    public static void initActions(int countHerbivore, int countPredator, int countGrass, int countRock,
                                   int countTree) {
        map = new Map(countHerbivore, countPredator, countGrass, countRock, countTree);
    }



    // просимулировать и отрендерить один ход
    public static void nextTurn() {
        Renderer.renderMap(map);
        makeStep();
        makeAction();
    }


    public static void printGame() {
        System.out.println("Введите команду:\n");
        System.out.println("1 - Сделать 1 шаг Симуляции");
        System.out.println("2 - Начать Симуляцию");
        System.out.println("0 - Выйти из игры");
    }

    public static void main(String[] args) throws InterruptedException {

        int countHerbivore = 5;
        int countPredator = 3;
        int countGrass = 5;
        int countRock = 4;
        int countTree = 3;

        printGame();

        initActions(countHerbivore, countPredator, countGrass, countRock, countTree);



        Scanner scanner = new Scanner(System.in);
        AtomicBoolean isRunning = new AtomicBoolean(true);

        while (isRunning.get()) {


            if (scanner.hasNextLine()) {


                // Чтение выбора пользователя
                int choice = 0;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    scanner.next(); // Очищаем некорректный ввод
                }

                // Обработка выбора с помощью switch
                switch (choice) {
                    case 1:
                        nextTurn();
                        break;

                    case 2:
                        int countHerbivoreSimulation = countHerbivore;
                        while (countHerbivoreSimulation > 0) {
                            nextTurn();
                            sleep(1000);
                            countHerbivoreSimulation = 0;
                            for (Entity entity : Map.mapObjects.values()) {
                                // Проверка, является ли entity экземпляром Herbivore
                                if (entity instanceof Herbivore) {
                                    countHerbivoreSimulation += 1;
                                }
                            }
                        }


                    case 0:
                        System.out.println("Выход из программы! Пока 👋");
                        isRunning.set(false); // Завершаем цикл
                        break;

                    default:
                        System.out.println("Неправильный ввод. Введи число от 0 до 2");
                        break;
                }
            }
        }
        scanner.close(); // Закрываем сканер для освобождения ресурсов
    }
}