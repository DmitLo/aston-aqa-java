package org.example;

import java.util.Scanner;

/*
Практическое задание Л12
Создайте 2 ветки: Lesson_12_junit_5.
Напишите программу, позволяющую вычислить факториал числа.
Эта программа должна быть в каждой ветке.
В ветке Lesson_12_junit_5 напишите юнит-тесты для этой программы,
используя Junit 5.
*/
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для вычисления факториала числа: ");
        int number = scanner.nextInt();

        long factorial = calculateFactorial(number);
        System.out.println("Факториал числа " + number + " равен " + factorial);
    }

    static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n > 0) {
            return n * calculateFactorial(n - 1);
        } else throw new IllegalArgumentException("Число не может быть отрицательным");
    }
}
