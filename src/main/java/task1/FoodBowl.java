package task1;

public class FoodBowl {

    private boolean isEmpty = true;
    private int countFood = 0;

    FoodBowl(int food) {
        if (food > 0) {
            this.countFood = food;
            isEmpty = false;
        }
    }

    public int getCountFood() {
        return countFood;
    }

    public void putFoodInBowl(int countFood) {
        if (isEmpty && (countFood > 0)) {
            this.countFood = countFood;
            isEmpty = false;
        } else if (countFood > 0) {
            this.countFood += countFood;
        } else {
            System.out.println("Можно только класть в миску");
        }
    }

    public boolean eatFromBowl(int eat) {
        if (isEmpty) {
            System.out.println("Миск пуста");
            return false;
        } else if (eat <= countFood) {
            countFood -= eat;
            return true;
        } else {
            System.out.println("В миске мало еды");
            return false;
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
