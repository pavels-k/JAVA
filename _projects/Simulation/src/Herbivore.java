import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// травоядное
public class Herbivore extends Creature {


    Herbivore(int x, int y) {
        super(1, x, y);
    }

    // сделать ход

    // движение травоядного
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


            // Если найдена трава
            if (map.getCellValue(x, y).equals("G")) {
                // понять направление, куда нужно идти
                int[] direction = getTowards(x, y, xCurrent, yCurrent);

                // соседняя координата должна быть пустой или травой

                // Добавить проверку выхода заграницы


                int newX = x + direction[0];
                int newY = y + direction[0];

                if (map.isValid(newX, newY)) {

                    // соседняя координата не должна быть пустой или травоядным
                    String CurrentPosition = map.getCellValue(newX, newY);

                    if (CurrentPosition != " " && CurrentPosition != "G") {
                        continue;
                    }

                    // изменить координату травоядному
                    map.setCellValue(xCurrent, yCurrent, " ");
                    this.x += direction[0];
                    this.y += direction[1];
                    map.setCellValue(this.x, this.y, "H");
                    this.addHp(20);
                    return;

                }


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
        // если трава не найдена сделай шаг в любую сторону
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];


            if (map.isValid(newX, newY)) {
                String currentPosition = map.getCellValue(newX, newY);

                // Если позиция свободна
                if (currentPosition == " ") {
                    map.setCellValue(xCurrent, yCurrent, " ");
                    this.x += direction[0];
                    this.y += direction[1];
                    map.setCellValue(this.x, this.y, "H");
                    return;
                }
            }
        }

    }


    // найти ресурс


    // eat
    public void doAction(Map map) {
        for (int[] direction : Simulation.DIRECTIONS) {
            if (map.getCellValue(x + direction[0], y + direction[1]).equals('G')) {

                map.setCellValue(x + direction[0], y + direction[1], " ");

                Grass grass = (Grass) Map.getCreatureByCoordinates(x + direction[0], y + direction[1]);
                this.addHp(grass.getHeal());
                grass = null;
                break;
            }
        }
    }


    // + получить урон
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            System.out.println("Травоядное уничтожено");
        }
    }

//    public void eatGrass() {
//        for (int[] direction : Simulation.DIRECTIONS) {
//            ;
//        }
//}
}