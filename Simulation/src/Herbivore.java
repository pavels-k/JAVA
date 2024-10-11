// травоядное
public class Herbivore extends Creature{


    Herbivore(int x, int y) {
        super(1, x, y);
    }

    // сделать ход

    public void makeMove(Map map) {

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
