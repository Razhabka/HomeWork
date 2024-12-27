package task2;

public class Rectangle implements Shape {

    private double sideA, sideB, sideC, sideD;
    private String fillColor, borderColor;

    public Rectangle(double sideA, double sideB, double sideC, double sideD, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
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
        return sideA + sideB + sideC + sideD;
    }

    @Override
    public double areaCalculation() {
        return sideA * sideB * sideC * sideD;
    }
}
