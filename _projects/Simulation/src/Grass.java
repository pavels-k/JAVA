import java.util.Random;


public class Grass extends Entity {
    // Ресурс для травоядных
    int x;
    int y;

    public Grass(int x, int y) {

        this.x = x;
        this.y = y;
    }

    int heal;

    public int getHeal() {
        return heal;
    }

    public Grass() {
        Random random = new Random();
        heal = 15 + random.nextInt(25 - 15 + 1);
    }
}
