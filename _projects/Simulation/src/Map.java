import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Map {
    //  Хранить координаты каждого существа
    //  и существо
    final int M = 20; // Ширина карты
    final int N = 20; // Длина карты

    // id, объект существа
    public static HashMap<Point, Entity> mapObjects = new HashMap<>();

    static ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

    // Генерация карты
    public Map(int countHerbivore, int countPredator, int countGrass, int countRock, int countTree) {
        mapObjects = new HashMap<>();
        for (int i = 0; i < M; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(" ");
            }
            arrayList.add(row);
        }
        arrangeOnMap(countHerbivore, countPredator, countGrass, countRock, countTree);

    }

    // расставить группу существ
    public void arrangeEntity(int countEntity, String symbol) {
        Random rand = new Random();
        int isOccupied;
        for (int i = 0; i < countEntity; i++) {
            isOccupied = 0;
            while (isOccupied == 0) {
                int randomX = rand.nextInt((M - 1));
                int randomY = rand.nextInt((N - 1));

                if (arrayList.get(randomX).get(randomY).equals(" ")) {
                    arrayList.get(randomX).set(randomY, symbol);
                    isOccupied = 2;
                    switch (symbol) {
                        case "H" -> {
                            Herbivore herbivore = new Herbivore(randomX, randomY);
                            addCreatureToMap(randomX, randomY, herbivore);
                        }
                        case "P" -> {
                            Predator predator = new Predator(randomX, randomY);
                            addCreatureToMap(randomX, randomY, predator);
                        }
                        case "G" -> {
                            Grass grass = new Grass(randomX, randomY);
                            addCreatureToMap(randomX, randomY, grass);
                        }
                    }
                }
            }
        }
    }

    // расставить на карту
    public void arrangeOnMap(int countHerbivore, int countPredator, int countGrass, int countRock, int countTree) {

        arrangeEntity(countHerbivore, "H");
        arrangeEntity(countPredator, "P");
        arrangeEntity(countGrass, "G");
        arrangeEntity(countRock, "R");
        arrangeEntity(countTree, "T");
    }

    // Добавить существо в хэшмапу mapObjects
    public void addCreatureToMap(int x, int y, Entity entity) {
        mapObjects.put(new Point(x, y), entity);
    }


    public String getCellValue(int i, int j) {
        return arrayList.get(i).get(j);
    }

    public static void setCellValue(int x, int y, int xOld, int yOld, String symbol) {
        arrayList.get(xOld).set(yOld, " ");

        if (mapObjects.containsKey(new Point(xOld, yOld))) {
            Entity valueEntity = mapObjects.remove(new Point(xOld, yOld)); // Удаляем старый ключ
            mapObjects.put(new Point(x, y), valueEntity); // Добавляем новый ключ с этим же значением
        } else {
            System.out.println("Key x = " + xOld + " y = " + yOld + " + not found in the map.");
        }


        arrayList.get(x).set(y, symbol);

    }


    // Метод для получения Creature по координатам
    public static Entity getCreatureByCoordinates(int x, int y) {
        if (x >= 0 && x < arrayList.size()) { // Проверяем, что x в пределах списка
            ArrayList<String> row = arrayList.get(x);
            if (y >= 0 && y < row.size()) { // Проверяем, что y в пределах строки
                if (mapObjects.containsKey(new Point(x, y))) {
                    return mapObjects.get(new Point(x, y)); // Возвращаем Creature, если ключ существует
                } else {
                    System.out.println("No Creature found for x = " + x + " y = " + y);
                }
            } else {
                System.out.println("Invalid Y coordinate: " + y);
            }
        } else {
            System.out.println("Invalid X coordinate: " + x);
        }
        return null; // Возвращаем null, если координаты некорректны или объект не найден
    }

    // Метод для удаления объекта по ID
    public static void removeEntity(int x, int y) {
        if (mapObjects.containsKey(new Point(x, y))) {
            mapObjects.remove(new Point(x, y));
            System.out.println("Creature with x = " + x + " y = " + y + " has been removed.");
        } else {
            System.out.println("No creature found with x = " + x + " y = " + y + ".");
        }
        arrayList.get(x).set(y, " ");
    }

    // проверка границы карты
    public boolean isValid(int xCurrent, int yCurrent) {
        return (xCurrent >= 0 && xCurrent < this.M && yCurrent >= 0 && yCurrent < this.N);
    }
}
