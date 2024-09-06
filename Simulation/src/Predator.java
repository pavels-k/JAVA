public class Predator extends Creature{
    private int attackPower;
    // переместиться
    // атаковать травоядное
    private void attackHerbivore(Herbivore herbivore){
        herbivore.takeDamage(attackPower);
    }
}
