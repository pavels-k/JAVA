
public abstract class Creature extends Entity {
    protected int hp;

    public int x;
    public int y;


    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // - сделать ход


    public int getHp() {
        return hp;
    }

    public void doAction(Map map) {
    }


    public void addHp(int healthIncrement) {
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


    // движение
    public abstract void makeMove(Map map);

    // сделать действие

}
