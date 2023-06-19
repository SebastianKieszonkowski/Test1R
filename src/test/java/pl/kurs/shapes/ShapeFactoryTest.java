package pl.kurs.shapes;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.shapes.models.Circle;
import pl.kurs.shapes.models.Rectangle;
import pl.kurs.shapes.models.ShapeFactory;
import pl.kurs.shapes.models.Square;

import static org.junit.Assert.*;

public class ShapeFactoryTest {

    ShapeFactory shapeFactory;
    Circle circle;
    Rectangle rectangle;
    Square square;

    @Before
    public void init() {
        shapeFactory = new ShapeFactory();
        circle = shapeFactory.createCircle(1.0);
        rectangle = shapeFactory.createRectangle(2.0, 3.0);
        square = shapeFactory.createSquare(4.0);
    }

    @Test
    public void createCircleMethodShouldCreateNewCircleWhenRadiusIs5() {
        //given
        double radius = 5.0;
        //when
        Circle circle2 = shapeFactory.createCircle(radius);
        //then
        assertTrue(shapeFactory.getShapes().contains(circle2));
    }

    @Test
    public void createCircleMethodShouldNotCreateNewCircleWhenRadiusIs1() {
        //given
        double radius = 1.0;
        //when
        Circle circle3 = shapeFactory.createCircle(radius);
        //then
        assertTrue(shapeFactory.getShapes().contains(circle3));
        assertEquals(circle, circle3);
    }

    @Test
    public void createRectangleMethodShouldCreateNewRectangleWhenLengthIs3AndWidth4() {
        //given
        double length = 3.0;
        double width = 4.0;
        //when
        Rectangle rectangle2 = shapeFactory.createRectangle(length, width);
        //then
        assertTrue(shapeFactory.getShapes().contains(rectangle2));
    }

    @Test
    public void createRectangleMethodShouldNotCreateNewRectangleWhenLengthIs2AndWidth3() {
        //given
        double length = 2.0;
        double width = 3.0;
        //when
        Rectangle rectangle3 = shapeFactory.createRectangle(length, width);
        //then
        assertTrue(shapeFactory.getShapes().contains(rectangle3));
        assertEquals(rectangle, rectangle3);
    }

    @Test
    public void createRectangleMethodShouldNotCreateNewRectangleWhenRadiusIs1() {
        //given
        double radius = 1.0;
        //when
        Circle circle3 = shapeFactory.createCircle(radius);
        //then
        assertTrue(shapeFactory.getShapes().contains(circle3));
        assertEquals(circle, circle3);
    }

    @Test
    public void createSquareMethodShouldCreateNewSquareWhenSideIs6() {
        //given
        double side = 6.0;
        //when
        Square square2 = shapeFactory.createSquare(side);
        //then
        assertTrue(shapeFactory.getShapes().contains(square2));

    }

    @Test
    public void createSquareMethodShouldNotCreateNewSquareWhenSideIs4() {
        //given
        double side = 4.0;
        //when
        Square square3 = shapeFactory.createSquare(side);
        //then
        assertTrue(shapeFactory.getShapes().contains(square3));
    }
}