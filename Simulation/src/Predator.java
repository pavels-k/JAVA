import java.util.UUID;

public class Predator extends Creature{
    private String id;

    public Predator(){
        this.id = UUID.randomUUID().toString();
    }


    // сделать ход
    public void makeMove(){
        ;
    }

    private int attackPower;
    // переместиться
    // атаковать травоядное
    private void attackHerbivore(Herbivore herbivore){
        herbivore.takeDamage(attackPower);
    }
}
