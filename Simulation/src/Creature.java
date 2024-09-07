import java.util.UUID;

public abstract class Creature extends Entity{
    private int speed;
    public int hp;

    private String id;

    public Creature(){
        this.id = UUID.randomUUID().toString();
    }
    // - сделать ход
    public abstract void makeMove();

    public String getId(){
        return id;
    }


}
