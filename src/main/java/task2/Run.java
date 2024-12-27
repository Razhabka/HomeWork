package task2;

public class Run {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(7,5,7,10,"red", "black");
        Circle circle = new Circle(5, "green", "blue");
        Rectangle rectangle = new Rectangle(10,15,10,15,"pink", "purple");

        System.out.println("Площадь треугольника: "+triangle.areaCalculation());
        System.out.println("Периметр треугольника: " + triangle.perimeterCalculation());
        System.out.println("Цвет границ треугольника: " + triangle.getBorderColor());
        triangle.setBorderColor("white");
        System.out.println("Цвет границ треугольника: " + triangle.getBorderColor());
        System.out.println("Цвет заливки треугольника: " + triangle.getFillColor());
        triangle.setFillColor("yellow");
        System.out.println("Цвет заливки треугольника: " + triangle.getFillColor());
        System.out.println();

        System.out.println("Площадь круга: "+circle.areaCalculation());
        System.out.println("Периметр круга: "+circle.perimeterCalculation());
        System.out.println("Цвет границ круга: " + circle.getBorderColor());
        triangle.setBorderColor("gray");
        System.out.println("Цвет границ круга: " + circle.getBorderColor());
        System.out.println("Цвет заливки круга: " + circle.getFillColor());
        triangle.setFillColor("orange");
        System.out.println("Цвет заливки круга: " + circle.getFillColor());
        System.out.println();

        System.out.println("Площадь прямоугольника: "+rectangle.areaCalculation());
        System.out.println("Периметр прямоугольника: "+rectangle.perimeterCalculation());
        System.out.println("Цвет границ прямоугольника: " + circle.getBorderColor());
        triangle.setBorderColor("red");
        System.out.println("Цвет границ прямоугольника: " + circle.getBorderColor());
        System.out.println("Цвет заливки прямоугольника: " + circle.getFillColor());
        triangle.setFillColor("lime");
        System.out.println("Цвет заливки прямоугольника: " + circle.getFillColor());



    }
}
