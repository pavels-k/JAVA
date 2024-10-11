import java.util.UUID;

public abstract class Creature extends Entity{
    public int speed;
    public int hp;

    public int x;
    public int y;

    private String id;

    public Creature(int speed, int x, int y) {
        this.speed = speed;
        this.id = UUID.randomUUID().toString();
        this.x = x;
        this.y = y;
    }
    // - сделать ход
    public abstract void makeMove(Map map);

    public String getId(){
        return id;
    }


}
