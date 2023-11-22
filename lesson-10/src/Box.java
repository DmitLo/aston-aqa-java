import java.util.ArrayList;

class Box<T extends Fruit> {
    final ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    // Нельзя пересыпать в ту же самую коробку
    public void transferFruitsToAnotherBox(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        // Нечего пересыпать
        if (fruits.isEmpty()) {
            return;
        }
        // Нельзя пересыпать фрукты разных видов
        if (!fruits.get(0).getClass().equals(anotherBox.fruits.get(0).getClass())) {
            return;
        }

        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
