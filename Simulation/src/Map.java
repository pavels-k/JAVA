import java.util.HashMap;

public class Map {
    //  Хранить координаты каждого существа
    //  и существо
    private HashMap<String, Creature> mapObjects;
    public Map(){
        mapObjects = new HashMap<>();
    }
    public void addObject(Creature creature){
        mapObjects.put(creature.ge);
    }

}