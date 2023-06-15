package pl.kurs.models;

import java.util.*;

public class ShapeFactory extends ShapeFactoryClass {
    private List<Circle> circlesRegister;
    private List<Rectangle> rectanglesRegister;
    private List<Square> squaresRegister;

    public ShapeFactory() {
        circlesRegister = new ArrayList<>();
        rectanglesRegister = new ArrayList<>();
        squaresRegister = new ArrayList<>();
    }

    @Override
    public Circle createCircle(double radius) {
        Circle circle = new Circle(radius);
        if (!circlesRegister.contains(circle)) {
            circlesRegister.add(circle);
        }
        return circlesRegister.get(circlesRegister.indexOf(circle));
    }

    @Override
    public Rectangle createRectangle(double length, double width) {
        Rectangle rectangle = new Rectangle(length, width);
        if(!rectanglesRegister.contains(rectangle)){
            rectanglesRegister.add(rectangle);
        }
        return rectanglesRegister.get(rectanglesRegister.indexOf(rectangle));
    }

    @Override
    public Square createSquare(double side) {
        Square square = new Square(side);
        if(!squaresRegister.contains(square)){
            squaresRegister.add(square);
        }
        return squaresRegister.get(squaresRegister.indexOf(square));
    }

    public List<Circle> getCirclesRegister() {
        return circlesRegister;
    }

    public List<Rectangle> getRectanglesRegister() {
        return rectanglesRegister;
    }

    public List<Square> getSquaresRegister() {
        return squaresRegister;
    }
}
