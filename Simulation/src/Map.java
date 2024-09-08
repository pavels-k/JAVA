import java.util.HashMap;
import java.util.ArrayList;

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
                row.add(0);hjghj
            }
            arrayList.add(row);
        }
    }


    // расставить существ
    public void arrangeСreatures(int countHerbivore, int countPredator){
        for (int i = 0; i < countHerbivore; i++) {
            ;
        }
        for (int i = 0; i < countPredator; i++) {
            ;
        }
    }

    public void addObject(Creature creature){
        mapObjects.put(creature.getId(), creature);
    }

}