import java.util.*;

public class Predator extends Creature {
    private String id;

    public Predator(int x, int y) {
        super(2, x, y);
        this.id = UUID.randomUUID().toString();
    }


    private int attackPower;

    // переместиться
    // атаковать травоядное
    private void attackHerbivore(Herbivore herbivore) {
        herbivore.takeDamage(attackPower);
    }

    // движение хищника
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
        visited[xCurrent][yCurrent] = true;


        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            int x = coordinates[0];
            int y = coordinates[1];


            // Выйди если проверяемая координата выходит за пределы видимости
            if (isVisible(x, xCurrent, y, yCurrent)) {
                continue;
            }


            // Если найдено травоядное
            if (map.getCellValue(x, y).equals("H")) {
                // понять направление, куда нужно идти
                int[] direction = getTowards(x, y, xCurrent, yCurrent);

                // изменить координату хищнику
                map.setCellValue(xCurrent, yCurrent, "O");
                this.x += direction[0];
                this.y += direction[1];
                map.setCellValue(this.x, this.y, "P");
                this.addHp(20);
                return;

            }

            // Добавить в очередь элемент
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (isValid(map, newX, newY) && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        ;
    }
}
