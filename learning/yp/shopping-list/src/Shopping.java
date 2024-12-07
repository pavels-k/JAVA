import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        int maxPurchaseSize = 8;

        String[] shoppingList = new String[maxPurchaseSize]; // сделать константой

        int productCount = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) { // добавить товар в список
                if (productCount == shoppingList.length) { // создание динамического массива
                    String[] shoppingListTmp = new String[(int) (maxPurchaseSize * 1.5)];
                    for (int i = 0; i < shoppingList.length; i++) {
                        shoppingListTmp[i] = shoppingList[i];
                    }
                    shoppingList = shoppingListTmp;
                    shoppingListTmp = new String[0]; // очистить временный массив
                }

                System.out.println("Напишите название товара:");
                String productName = scanner.next();

                // проверка на дубликаты без использования дополнительных библиотек
                boolean hasDuplicate = false;
                for (int i = 0; i < productCount; i++) {
                    if (shoppingList[i].equalsIgnoreCase(productName)) {
                        hasDuplicate = true;
                    }
                }

                if (!hasDuplicate) {
                    shoppingList[productCount] = productName; // добавить товар
                    productCount++;
                    System.out.println("Товар " + productName.toLowerCase() + " добавлен в список под номером "
                            + productCount);
                } else {
                    System.out.println("Данный товар уже есть в списке покупок");
                }


            } else if (actionNumber == 2) { // показать список
                System.out.println();

                System.out.println("Текущий список покупок:");
                if (productCount == 0) {
                    System.out.println("Текущий список покупок пуст");
                }
                for (int i = 0; i < productCount; i++) {
                    System.out.println((i + 1) + ". " + shoppingList[i]);
                }

            } else if (actionNumber == 3) { // очистить список
                if (productCount != 0) {
                    for (int i = 0; i < productCount; i++) {
                        shoppingList[i] = null;
                    }
                    productCount = 0;
                    System.out.println("Теперь список пуст");
                } else {
                    System.out.println("Список уже пуст");
                }

            } else if (actionNumber == 4) { // завершить работу
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}