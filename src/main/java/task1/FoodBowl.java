package task1;

public class FoodBowl {

    private int countFood = 0;

    FoodBowl(int food) {
        if (food > 0) {
            this.countFood = food;
        }
    }

    public int getCountFood() {
        return countFood;
    }

    public void putFoodInBowl(int countFood) {
        if (countFood > 0) {
            this.countFood = countFood;
        } else if (countFood > 0) {
            this.countFood += countFood;
        } else {
            System.out.println("Можно только класть в миску");
        }
    }

    public boolean eatFromBowl(int eat) {
        if (countFood == 0) {
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

}
