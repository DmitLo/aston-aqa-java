import java.util.ArrayList;

/*
Необходимо написать программу, позволяющую выполнить следующее:
1. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
2. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку
нельзя сложить и яблоки, и апельсины;
3. Для хранения фруктов внутри коробки можно использовать ArrayList;
4. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут
в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки
с яблоками и апельсинами;
6. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в
другую перекидываются объекты, которые были в первой;
7. Не забываем про метод добавления фрукта в коробку
 */
public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple(1.0f));
        appleBox1.addFruit(new Apple(1.0f));

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple(1.0f));

        // вес коробки с думя яблоками
        System.out.println("Вес appleBox1 " + appleBox1.getWeight());
        // вес коробки с двумя апельсинами
        System.out.println("Вес orangeBox " + orangeBox.getWeight());
        // результат сравнения двух коробок
        System.out.println("Коробки равны по весу? " + appleBox1.compare(orangeBox));

        appleBox1.transferFruitsToAnotherBox(appleBox2);

        // вес первой коробки яблок после пересыпки с нее
        System.out.println("Вес appleBox1 после передачи " + appleBox1.getWeight());
        // вес второй коробки яблок после пересыпки и добавления яблок
        System.out.println("Вес appleBox2 после передачи " + appleBox2.getWeight());
    }
}