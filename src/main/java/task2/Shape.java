package task2;

public interface Shape {

    void setFillColor();
    void setBorderColor();

    String getFillColor();
    String getBorderColor();
    double getPerimeter();
    double getArea();

    default double perimeterCalculation(){
        return 0.0;
    }
}
