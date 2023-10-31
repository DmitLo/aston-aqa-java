package plates;

public class Plate {
    private int food;

    //конструктор
    public Plate(int food) {
        this.food = food;
    }

    //получить еду
    public int getFood() {
        return food;
    }

    //метод уменьшения еды
    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }

    //метод добавления еды
    public void addFood(int amount) {
        food += amount;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
