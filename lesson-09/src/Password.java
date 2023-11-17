import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
5. Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
Как только пользователь введет пустую строку - программа должна прекратить приём данных от
пользователя и вывести в консоль логины, начинающиеся на букву f (строчную).
*/
public class Password {
    public static void main(String[] args) {
        List<String> logins = readLoginsFromUser();
        System.out.println("Логины начинаются с f " + filterLoginsStartingWithF(logins));
    }

    // считывание логина, пока не введена пустая строка
    private static List<String> readLoginsFromUser() {
        List<String> logins = new ArrayList<>();
        // ввод логина с клавиатуры
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String login = scanner.nextLine();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }
        return logins;
    }

    // фильтрация логина, оставляя только те, которые начинаются с буквы 'f'
    private static List<String> filterLoginsStartingWithF(List<String> logins) {
        List<String> filteredLogins = new ArrayList<>();
        for (String login : logins) {
            if (login.startsWith("f")) {
                filteredLogins.add(login);
            }
        }
        return filteredLogins;
    }
}
