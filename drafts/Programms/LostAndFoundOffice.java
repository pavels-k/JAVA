import java.util.ArrayList;

public class LostAndFoundOffice {
    // создайте список things
    ArrayList<Object> things;

    // реализуйте метод put()
    public void put(Object element) {
        things.add(element);
    }

    // реализуйте метод check()
    public boolean check(Object element) {
        if (element == null) {
            return false;
        }

        for (Object object : things) { // логика проверки вещи в списке
            if (object.equals(element)) {
                return true;
            }
        }
        return false;
    }

}