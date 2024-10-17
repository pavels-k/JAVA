import java.util.UUID;

public abstract class Creature extends Entity{
    private int speed;
    protected  int hp;

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

    public String getId(){
        return id;
    }


    public void addHp(int healthIncrement){
        hp = Math.min(hp + healthIncrement, 100);
    }

    // движение
    public abstract void makeMove(Map map);
}
