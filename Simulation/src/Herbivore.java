import java.util.UUID;

public class Herbivore extends Creature{
    private String id;

    public Herbivore(){
        this.id = UUID.randomUUID().toString();
    }

    // сделать ход
    public void makeMove(){
        ;
    }

    // найти ресурс
    // движение
    // eat
    // + получить урон
    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp <= 0){
            System.out.println("Травоядное уничтожено");
        }
    }
}
