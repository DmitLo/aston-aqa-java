import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии. Следует учесть,
что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны
*/
public class Main {
    public static void main(String[] args) {
        // Создаем массив с набором слов
        String[] wordsArray = {"apple", "banana", "orange", "apple", "grape",
                "banana", "apple", "kiwi", "orange", "kiwi", "grape",
                "melon", "kiwi", "banana", "melon", "apple", "orange",
                "grape", "melon", "kiwi"};

        // Находим уникальные слова и считаем их колличество
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : wordsArray) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        List<String> uniqueWords = new ArrayList<>(wordCounts.keySet());

        // Выводим список уникальных слов и их количество
        System.out.println("args   = " + uniqueWords);
        System.out.println("args = " + wordCounts);
        System.out.println();

        // Простой телефонный справочник
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в справочник
        phoneBook.add("Иванов", "123-456-789");
        phoneBook.add("Петров", "987-654-321");
        phoneBook.add("Иванов", "555-123-456");
        phoneBook.add("Сидоров", "111-222-333");
        phoneBook.add("Петров", "777-888-999");

        // Ищем номер телефона по фамилии
        System.out.println("Телефон Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров"));
        System.out.println("Телефоны Новикова: " + phoneBook.get("Новиков"));
    }
}
