public class Herbivore extends Creature{
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
