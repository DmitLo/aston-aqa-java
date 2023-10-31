package circle;

/*
Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
круг, прямоугольник, треугольник.
Задать для каждой фигуры цвет заливки и цвет границы.
Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ]
по каждой фигуре вывести в консоль.
Попробуйте реализовать базовые методы, такие как расчет периметра фигур,
в качестве дефолтных методов в интерфейсе.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Circle(5.0, "black", "white"),
                new Rectangle(3.0, 4.0, "black", "yellow"),
                new Triangle(3.0, 4.0, 5.0, "green", "yellow")
        };
        //вывод значений
        for (Shape shape : shapes) {
            System.out.println("Shape Type: " + shape.getClass().getSimpleName());
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println("Fill Color: " + shape.getFillColor());
            System.out.println("Border Color: " + shape.getBorderColor());
            System.out.println();
        }
    }
}
