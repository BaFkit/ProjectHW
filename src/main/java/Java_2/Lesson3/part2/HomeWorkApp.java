package Java_2.Lesson3.part2;

import java.util.ArrayList;

public class HomeWorkApp {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(790005000, "Smirnov");
        phoneBook.add(778964444, "Sidorow");
        phoneBook.add(759556655, "Sergeev");
        phoneBook.add(733354443, "Sidorow");
        phoneBook.add(799999999, "Kruglow");

        phoneBook.getPhone("Sidorow");  //метод возвращзает ArrayList такой вывод для проверки.
        phoneBook.getPhone("Kruglow");
        phoneBook.getPhone("Sergeev");
        phoneBook.getPhone("Smirnov");


    }


}
