import java.util.UUID;

public class Predator extends Creature{
    private String id;

    public Predator(int x, int y){
        super(2, x, y);
        this.id = UUID.randomUUID().toString();
    }


    // сделать ход
    public void makeMove(Map map) {
        ;

    }

    private int attackPower;
    // переместиться
    // атаковать травоядное
    private void attackHerbivore(Herbivore herbivore){
        herbivore.takeDamage(attackPower);
    }
}
