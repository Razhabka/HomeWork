package task1;

public class Animal {


    private static int animalCounter = 0;

    Animal() {
        animalCounter++;
    }

    public static void getAnimalCounter() {
        System.out.printf("Было создано животных %d", animalCounter);
    }

    public void run(int dist) {
        System.out.printf("Животное бежит %d\n", dist);
    }

    public void swim(int dist) {
        System.out.printf("Животное плывет %d\n", dist);
    }
}
