package task1;

public class Run {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barseek", 12);
        Cat cat2 = new Cat("Kitty", 6);
        Dog dog1 = new Dog("Sharik", 3);
        FoodBowl barseekBowl = new FoodBowl(50);

        cat1.run(150);
        cat1.run(201);
        cat1.swim(10);
        Cat.getCatCounter();
        cat1.isHungry();
        cat1.eat(barseekBowl);
        cat1.isHungry();
        cat2.isHungry();
        cat2.eat(barseekBowl);
        cat2.isHungry();

        System.out.println();

        dog1.run(450);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(45);
        Dog.getDogCounter();


        System.out.println();
        Animal.getAnimalCounter();
        System.out.println();

        FoodBowl bowl = new FoodBowl(170);

        Cat[] cats = new Cat[]{new Cat("Murzik", 4), new Cat("Chucha", 7),
                new Cat("Shisha", 12), new Cat("Pupi", 3)};
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        for (Cat cat : cats) {
            cat.isHungry();
        }
        System.out.println(bowl.getCountFood());
        Cat.getCatCounter();
        Animal.getAnimalCounter();
    }
}
