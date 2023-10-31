package plates;

public class Cat {
    String name;
    //аппетит
    private int appetite;
    //наелся или нет
    private boolean fullness;

    //конструктор
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            fullness = true;
        }
    }

    //метод наелся или нет
    public boolean ifFull() {
        return fullness;
    }
}
