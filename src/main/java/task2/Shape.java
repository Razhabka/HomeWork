package task2;

public interface Shape {

    void setFillColor(String color);

    void setBorderColor(String color);

    String getFillColor();

    String getBorderColor();

    default double perimeterCalculation() {
        return 0.0;
    }

    default double areaCalculation() {
        return 0.0;
    }
}
