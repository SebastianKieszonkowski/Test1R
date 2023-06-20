package pl.kurs.shapes.models;

import pl.kurs.shapes.models.Circle;
import pl.kurs.shapes.models.Rectangle;
import pl.kurs.shapes.models.Square;

import java.util.List;
import java.util.Map;

public abstract class AbstractShapeFactory {
    public abstract Circle createCircle(double radius);

    public abstract Rectangle createRectangle(double length, double width);

    public abstract Square createSquare(double side);

    public abstract Map<String, IShape> getShapes();

}
