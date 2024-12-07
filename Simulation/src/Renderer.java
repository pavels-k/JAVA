// Нарисовать поле
public class Renderer extends Entity {


    // отрисовать карту
    public static void renderMap(Map map) {
        for (int i = 0; i < map.M; i++) {
            System.out.print('=');
        }
        System.out.println('=');

        for (int i = 0; i < map.M; i++) {
            for (int j = 0; j < map.N; j++) {
                if (map.getCellValue(i, j).equals("P")) {
                    System.out.print("\u001B[31m" + map.getCellValue(i, j) + "\u001B[0m");

                } else if (map.getCellValue(i, j).equals("H")) {
                    System.out.print("\u001B[34m" + map.getCellValue(i, j) + "\u001B[0m");
                } else if (map.getCellValue(i, j).equals("G")) {
                    System.out.print("\u001B[32m" + map.getCellValue(i, j) + "\u001B[0m");
                } else {
                    System.out.print(map.getCellValue(i, j));

                }
            }
            System.out.println();
        }
        for (int i = 0; i < map.M; i++) {
            System.out.print('=');
        }
        System.out.println('=');
    }


}
