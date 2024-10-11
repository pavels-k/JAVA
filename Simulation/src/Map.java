import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Map {
    //  Хранить координаты каждого существа
    //  и существо
    final int M = 20; // Ширина карты
    final int N = 20; // Длина карты

    private static HashMap<String, Creature> mapObjects;

    // 0 - свободно
    // 1 - хищник
    // 2 - травоядное
    private static ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

    public Map(int countHerbivore, int countPredator, int countGrass, int countRock, int countTree) {
        mapObjects = new HashMap<>();
        for (int i = 0; i < M; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add("O");
            }
            arrayList.add(row);
        }
        arrangeOnMap(countHerbivore, countPredator, countGrass, countRock, countTree);


    }

    public void arrangeEntity(int countEntity, String symbol) {
        Random rand = new Random();
        int isOccupied;
        for (int i = 0; i < countEntity; i++) {
            isOccupied = 0;
            while (isOccupied == 0) {
                int randomX = rand.nextInt((M - 1));
                int randomY = rand.nextInt((N - 1));

                if (arrayList.get(randomX).get(randomY).equals("O")) {
                    arrayList.get(randomX).set(randomY, symbol);
                    isOccupied = 2;
                    if (symbol.equals("H")) {
                        Herbivore herbivore = new Herbivore(randomX, randomY);
                        addCreatureToMap(herbivore);
                    } else if (symbol.equals("P")) {
                        Predator predator = new Predator(randomX, randomY);
                        addCreatureToMap(predator);
                    }
                }
            }
        }
    }

    // расставить существ
    public void arrangeOnMap(int countHerbivore, int countPredator, int countGrass, int countRock, int countTree) {

        arrangeEntity(countHerbivore, "H");
        arrangeEntity(countPredator, "P");
        arrangeEntity(countGrass, "G");
        arrangeEntity(countRock, "R");
        arrangeEntity(countTree, "T");
    }

    public void addCreatureToMap(Creature creature) {
        mapObjects.put(creature.getId(), creature);
    }

    public String getCellValue(int i, int j) {
        return arrayList.get(i).get(j);
    }
}