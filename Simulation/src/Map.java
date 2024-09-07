import java.util.HashMap;

public class Map {
    //  Хранить координаты каждого существа
    //  и существо
    final int M = 20; // Ширина карты
    final int N = 20; // Длина карты

    private static HashMap<String, Creature> mapObjects;


    public Map(){
        mapObjects = new HashMap<>();
    }
    public void addObject(Creature creature){
        mapObjects.put(creature.getId(), creature);
    }

}