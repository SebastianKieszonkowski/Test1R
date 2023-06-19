package pl.kurs.shapes.models;

import java.util.*;

public class ShapeFactory extends AbstractShapeFactory {
    private List<IShape> shapeRegister;

    public ShapeFactory() {
        shapeRegister = new ArrayList<>();
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
        if (!shapeRegister.contains(shape)) {
            shapeRegister.add(shape);
        }
        return shapeRegister.get(shapeRegister.indexOf(shape));
    }

    @Override
    public List<IShape> getShapes() {
        return shapeRegister;
    }
}
