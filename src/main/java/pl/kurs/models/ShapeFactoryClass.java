package pl.kurs.models;

public abstract class ShapeFactoryClass {
    public abstract Circle createCircle(double radius);
    public abstract Rectangle createRectangle(double length, double width);
    public abstract Square createSquare(double side);
}
