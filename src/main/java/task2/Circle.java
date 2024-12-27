package task2;

public class Circle implements Shape {
    private double radius;
    private final double PI = 3.14;
    private String fillColor, borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double perimeterCalculation() {
        return 2 * PI * radius;
    }

    @Override
    public double areaCalculation() {
        return PI * (radius * radius);
    }
}
