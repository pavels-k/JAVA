import java.util.*;

public class Predator extends Creature {

    public Predator(int x, int y) {
        super(x, y);
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

                int newX = x + direction[0];
                int newY = y + direction[1];

                if (map.isValid(newX, newY)) {

                    // соседняя координата не должна быть пустой или травоядным
                    String CurrentPosition = map.getCellValue(newX, newY);


                    if (!Objects.equals(CurrentPosition, " ") && !Objects.equals(CurrentPosition, "P")) {
                        continue;
                    }
                }

                // изменить координату хищнику
                this.x += direction[0];
                this.y += direction[1];

                map.setCellValue(this.x, this.y, xCurrent, yCurrent, "P");
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
            if (map.isValid(newX, newY)) {
                String currentPosition = map.getCellValue(newX, newY);

                // Если позиция свободна
                if (Objects.equals(currentPosition, " ")) {
                    this.x += direction[0];
                    this.y += direction[1];
                    map.setCellValue(this.x, this.y, xCurrent, yCurrent, "P");
                    return;
                }
            }
        }
    }

    @Override
    public void doAction(Map map) {

        for (int[] direction : Simulation.DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (map.isValid(newX, newY)) {
                if (map.getCellValue(newX, newY).equals("H")) {
                    // вытяни травоядного


                    Herbivore herbivore = (Herbivore) Map.getCreatureByCoordinates(newX, newY);
                    assert herbivore != null;
                    herbivore.takeDamage(20);
                    if (herbivore.getHp() <= 0) {

                        // Удаление травоядного
                        map.removeEntity(x, y);
                        map.arrayList.get(newX).set(newY, " ");
                        herbivore = null;
                    }
                    break;
                }
            }
        }
    }
}


