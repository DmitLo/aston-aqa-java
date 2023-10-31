package animals;

public class Cat extends Animal {
    //предел бега
    int runLimit = 200;
    //предел плавания
    int swimLimit = 0;

    public Cat(String name) {
        super(name);
    }

    //Переопределение метода бежать

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
}
