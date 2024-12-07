import java.util.Objects;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Переопределяем equals() для корректного сравнения координат
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылки
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и совпадение классов
        Point point = (Point) o;
        return x == point.x && y == point.y; // Сравниваем значения x и y
    }

    // Переопределяем hashCode() для корректной работы с HashMap
    @Override
    public int hashCode() {
        return Objects.hash(x, y); // Генерируем хэш на основе x и y
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}