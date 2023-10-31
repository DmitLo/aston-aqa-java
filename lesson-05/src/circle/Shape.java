package circle;

public interface Shape {
    //вычисление площади и периметра
    double calculateArea();

    double calculatePerimeter();

    //установка и получение цвета
    String getFillColor();

    void setFillColor(String fillColor);

    String getBorderColor();

    void setBorderColor(String borderColor);
}
