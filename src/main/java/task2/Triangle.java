package task2;

public class Triangle implements Shape{
    private double sideA, sideB,sideC;




    @Override
    public void setFillColor() {

    }

    @Override
    public void setBorderColor() {

    }

    @Override
    public String getFillColor() {
        return "";
    }

    @Override
    public String getBorderColor() {
        return "";
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double perimeterCalculation() {
        return Shape.super.perimeterCalculation();
    }
}
