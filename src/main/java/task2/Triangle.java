package task2;

public class Triangle implements Shape {
    private double sideLeft, footing, sideRight, height;
    private String fillColor, borderColor;

    public Triangle(double sideLeft, double footing, double sideRight, double height, String fillColor, String borderColor) {
        this.sideLeft = sideLeft;
        this.footing = footing;
        this.sideRight = sideRight;
        this.height = height;
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
        return sideLeft + sideRight + footing;
    }

    @Override
    public double areaCalculation() {
        return footing * height / 2;
    }


}
