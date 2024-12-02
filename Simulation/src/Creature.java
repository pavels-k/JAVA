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


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getId(){
        return id;
    }


    public void addHp(int healthIncrement){
        hp = Math.min(hp + healthIncrement, 100);
    }

    // Находится ли в зоне видимости проверяемая координата для существа
    public boolean isVisible(int x, int xCurrent, int y, int yCurrent) {
        return (Math.abs(x - xCurrent) > 4) || (Math.abs(y - yCurrent) > 4);
    }

    // Определить направление хода на одну клетку
    public int[] getTowards(int x, int y, int xCurrent, int yCurrent) {
        if (Math.abs(x - xCurrent) > Math.abs((y - yCurrent))) {
            return new int[]{x - xCurrent > 0 ? 1 : -1, 0};
        }
        return new int[]{0, y - yCurrent > 0 ? 1 : -1};
    }

    // проверка границы карты
    public boolean isValid(Map map, int xCurrent, int yCurrent) {
        return (xCurrent >= 0 && xCurrent < map.M && yCurrent >= 0 && yCurrent < map.N);
    }


    // движение
    public abstract void makeMove(Map map);

    // сделать действие

}
