package task1;

public class Cat extends Animal {
    private String name;
    private int age;
    private boolean hungry = true;

    private static int catCounter = 0;

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
        catCounter++;
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

    public void isHungry() {
        if (hungry) {
            System.out.printf("Кот %s очень голодный\n", name);
        } else {
            System.out.printf("Кот %s сыт\n", name);
        }
    }

    public static void getCatCounter() {
        System.out.printf("Было создано %d котов\n", catCounter);
    }


    @Override
    public void run(int dist) {
        if (dist < 200) {
            System.out.printf("Кот %s, пробежал %d метров.\n", name, dist);
        } else {
            System.out.printf("Кот за раз может пробежать не больше 200м.(Ваше значение %dм)\n", dist);
        }
    }

    @Override
    public void swim(int dist) {
        System.out.println("Коты не умеют плавать");
    }

    public void eat(FoodBowl bowl) {
        if (hungry) {
            if (bowl.eatFromBowl(50)) {
                System.out.printf("Кот %s ест\n", name);
                hungry = false;
            } else {
                System.out.printf("Коту %s не хватает еды\n", name);
            }
        } else {
            System.out.println("Кот не голодный");
        }
    }
}
