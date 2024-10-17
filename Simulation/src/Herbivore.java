//import java.util.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// травоядное
public class Herbivore extends Creature{


    Herbivore(int x, int y) {
        super(1, x, y);
    }

    // сделать ход

    // движение
    @Override
    public void makeMove(Map map) {
        // Пока не увидит траву

        int xCurrent = this.x;
        int yCurrent = this.y;

        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});

        // максимум на 4 хода видит
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{xCurrent, yCurrent});
        boolean[][] visited = new boolean[map.M][map.N];

        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            int x = coordinates[0];
            int y = coordinates[1];


            // Выйди если проверяемая координата выходит за пределы видимости
            if (isVisible(x, xCurrent, y, yCurrent)) {
                continue;
            }


            // Если найдена трава
            if (map.getCellValue(x, y).equals("G")) {
                // понять направление, куда нужно идти
                int[] direction = getTowards(x, y, xCurrent, yCurrent);

                map.setCellValue(xCurrent, yCurrent, "O");
                this.x += direction[0];
                this.y += direction[1];
                map.setCellValue(this.x, this.y, "G");
                this.addHp(20);
                return;

            }

            // Добавить в очередь элемент
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (isValid(map, newX, newY)) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        ;
    }

    private int[] getTowards(int x, int y, int xCurrent, int yCurrent) {
        if (Math.abs(x - xCurrent) > Math.abs((y - yCurrent))) {
            return new int[]{x - xCurrent > 0 ? 1 : -1, 0};
        }
        return new int[]{0, y - yCurrent > 0 ? 1 : -1};
    }

    private boolean isVisible(int x, int xCurrent, int y, int yCurrent) {
        return (Math.abs(x - xCurrent) > 4) || (Math.abs(y - yCurrent) > 4);
    }

    private boolean isValid(Map map, int xCurrent, int yCurrent) {
        return (xCurrent >= 0 && xCurrent < map.M && yCurrent >= 0 && yCurrent < map.N);
    }


    // найти ресурс


    // eat

    // + получить урон
    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp <= 0){
            System.out.println("Травоядное уничтожено");
        }
    }
}
