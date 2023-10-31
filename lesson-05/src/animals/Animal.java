package animals;

public class Animal {
    //количество животных
    static int totalAnimals = 0;
    //название животного
    String name;

    //конструктор
    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    //метод бежать
    public void run(int distance) {
    }

    //метод плыть
    public void swim(int distance) {
    }

    //подсчет количества животных
    public static int getTotalAnimals() {
        return totalAnimals;
    }

}
