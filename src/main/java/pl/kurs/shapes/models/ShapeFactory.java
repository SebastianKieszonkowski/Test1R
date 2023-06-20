package pl.kurs.shapes.models;

import java.util.*;

public class ShapeFactory extends AbstractShapeFactory {
    private Map<String, IShape> shapeRegister;

    public ShapeFactory() {
        shapeRegister = new HashMap<>();
    }

    @Override
    public Circle createCircle(double radius) {
        return (Circle) saveIfUnique(new Circle(radius));
    }

    @Override
    public Rectangle createRectangle(double length, double width) {
        return (Rectangle) saveIfUnique(new Rectangle(length, width));
    }

    @Override
    public Square createSquare(double side) {
        return (Square) saveIfUnique(new Square(side));
    }

    private IShape saveIfUnique(IShape shape) {
        String shapeKey = shape.getKey();
        if (!shapeRegister.containsKey(shapeKey)) {
            shapeRegister.put(shapeKey, shape);
        }
        return shapeRegister.get(shapeKey);
    }

    @Override
    public Map<String, IShape> getShapes() {
        return shapeRegister;
    }
}
