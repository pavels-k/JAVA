import java.util.*;

public class Predator extends Creature {
    private String id;
    private int attackPower;

    public Predator(int x, int y) {
        super(2, x, y);
        this.id = UUID.randomUUID().toString();
    }


    // атаковать травоядное
    private void attackHerbivore(Herbivore herbivore) {
        herbivore.takeDamage(attackPower);
    }

    // движение хищника
    @Override
    public void makeMove(Map map) {
        // Пока не увидит травоядного

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

                // соседняя координата не должна быть пустой или травоядным
                String CurrentPosition = map.getCellValue(x + direction[0], y + direction[0]);
                if (CurrentPosition != "O" && CurrentPosition != "P") {
                    continue;
                }

                // изменить координату хищнику
                map.setCellValue(xCurrent, yCurrent, "O");
                this.x += direction[0];
                this.y += direction[1];

                map.setCellValue(this.x, this.y, "P");
                this.addHp(10); // когда
                return;
            }

            // Добавить в очередь элемент
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (map.isValid(newX, newY) && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        // если трава не найдена сделай шаг в любую сторону, но не в сторону хищника
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            String currentPosition = map.getCellValue(newX, newY);

            // Если позиция свободна
            if (map.isValid(newX, newY) && currentPosition == "O") {
                map.setCellValue(xCurrent, yCurrent, "O");
                this.x += direction[0];
                this.y += direction[1];
                map.setCellValue(this.x, this.y, "P");
                return;
            }
        }
    }
}
