import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2. Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload».
Нужно с ней выполнить следующие манипуляции:
2.1. Посчитать, сколько раз объект «High» встречается в коллекции;
2.2. Определить, какой элемент в коллекции находится на первом месте.
Если мы получили пустую коллекцию, то пусть возвращается 0;
2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию,
то пусть возвращается 0;
*/
public class Manipulations {
    public static void main(String[] args) {
        // исходная коллекция
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        long countHigh = getCountOfHigh(collection);
        String firstElement = getFirstElement(collection);
        String lastElement = getLastElement(collection);

        System.out.println("Количество High " + countHigh);
        System.out.println("Первый элемент " + firstElement);
        System.out.println("Последний эелемент " + lastElement);
    }

    // подсчет вхождений "High"
    private static long getCountOfHigh(List<String> collection) {
        return collection.stream().filter(s -> s.equals("High")).count();
    }

    // получение первого элементов
    private static String getFirstElement(List<String> collection) {
        return collection.isEmpty() ? "0" : collection.get(0);
    }

    // получение последнего элементов
    private static String getLastElement(List<String> collection) {
        return collection.isEmpty() ? "0" : collection.get(collection.size() - 1);
    }
}
