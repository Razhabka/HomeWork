package task2;

public class Rectangle implements Shape {

    private double sideA, sideB;
    private String fillColor, borderColor;

    public Rectangle(double sideA, double sideB, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
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
        return (sideA + sideB) * 2;
    }

    @Override
    public double areaCalculation() {
        return Math.sqrt(sideA) * Math.sqrt(sideB);
    }
}
