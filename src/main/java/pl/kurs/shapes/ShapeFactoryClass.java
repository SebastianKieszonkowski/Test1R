package pl.kurs.shapes;

import pl.kurs.shapes.Circle;
import pl.kurs.shapes.Rectangle;
import pl.kurs.shapes.Square;

public abstract class ShapeFactoryClass {
    public abstract Circle createCircle(double radius);
    public abstract Rectangle createRectangle(double length, double width);
    public abstract Square createSquare(double side);
}
