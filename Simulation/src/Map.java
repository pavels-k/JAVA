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
    private static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public Map(int countHerbivore, int countPredator) {
        mapObjects = new HashMap<>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(0);
            }
            arrayList.add(row);
        }
        arrangeСreatures(countHerbivore, countPredator);
    }


    // расставить существ
    public void arrangeСreatures(int countHerbivore, int countPredator){
        Random rand = new Random();
        int isOccupied;
        for (int i = 0; i < countHerbivore; i++) {
            isOccupied = 0;
            while (isOccupied == 0) {
                int randomM = rand.nextInt((M));
                int randomN = rand.nextInt((N));

                if (arrayList.get(randomM).get(randomN) == 0) {
                    arrayList.get(randomM).set(randomN, 2); // 2 - Травоядное
                    isOccupied = 2;
                }
            }


        }
        for (int i = 0; i < countPredator; i++) {
            isOccupied = 0;
            while (isOccupied == 0) {
                int randomM = rand.nextInt((M) + 1);
                int randomN = rand.nextInt((N) + 1);

                if (arrayList.get(randomM).get(randomN) == 0) {
                    arrayList.get(randomM).set(randomN, 1); // 1 - Хищник
                    isOccupied = 1;
                }
            }

        }
    }

    public void addObject(Creature creature){
        mapObjects.put(creature.getId(), creature);
    }

    public int getCellValue(int i, int j) {
        return arrayList.get(i).get(j);
    }
}