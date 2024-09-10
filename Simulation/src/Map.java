import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    //  Хранить координаты каждого существа
    //  и существо
    final int M = 20; // Ширина карты
    final int N = 20; // Длина карты

    private static HashMap<String, Creature> mapObjects;
    private static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public Map(){
        mapObjects = new HashMap<>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(0);
            }
            arrayList.add(row);
        }
    }


    // расставить существ
    public void arrangeСreatures(int countHerbivore, int countPredator){
        Random rand = new Random();
        for (int i = 0; i < countHerbivore; i++) {

            int randomM = rand.nextInt((M) + 1); // Generates a number between min and max
            int randomN = rand.nextInt((N) + 1); // Generates a number between min and max

            if (arrayList.get(randomM).get(randomN) != 0){
                arrayList.get(randomM).set(randomN, 1);
            }
        }
        for (int i = 0; i < countPredator; i++) {
            ;
        }
    }

    public void addObject(Creature creature){
        mapObjects.put(creature.getId(), creature);
    }

}