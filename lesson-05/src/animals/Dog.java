package animals;

public class Dog extends Animal {
    //предел бега
    int runLimit = 500;
    //предел плавания
    int swimLimit = 10;

    public Dog(String name) {
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
        if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м");
        }
    }
}
