package task1;

public class Dog extends Animal {
    private String name;
    private int age;

    private static int dogCounter = 0;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        dogCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void getDogCounter() {
        System.out.printf("Было создано %d собак\n", dogCounter);
    }

    @Override
    public void run(int dist) {
        if(dist < 500) {
            System.out.printf("Собака %s, пробежала %dм.\n", name, dist);
        }else {
            System.out.printf("Собака за раз может пробежать только 500м.(Ваше значение %dм)\n", dist);
        }
    }

    @Override
    public void swim(int dist) {
        if(dist<10){
            System.out.printf("Собака %s, проплыла %dм\n", name, dist);
        }else {
            System.out.printf("Собака за раз может проплыть только 10м.(Ваше значени %dм)\n", dist);
        }
    }
}
