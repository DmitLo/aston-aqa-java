import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
1. Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.
*/
public class EventNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(10);
        List<Integer> eventNumbers = getEvenNumbers(numbers);
        int countEventNumbers = eventNumbers.size();

        System.out.println("Сгенерированные числа " + numbers);
        System.out.println("Четные числа " + eventNumbers);
        System.out.println("Количество " + countEventNumbers);
    }

    // генерация случайных чисел
    public static List<Integer> generateRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(100) + 1);
        }
        return numbers;
    }

    // подсчет четных чисел
    public static List<Integer> getEvenNumbers(List<Integer> numbers) {
        List<Integer> eventNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                eventNumbers.add(number);
            }
        }
        return eventNumbers;
    }
}