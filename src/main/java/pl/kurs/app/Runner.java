package pl.kurs.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import pl.kurs.models.*;
import pl.kurs.service.ObjectMapperHolder;
import pl.kurs.service.ShapeService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {

        ShapeFactory shapeFactory = new ShapeFactory();

        Circle c1 = shapeFactory.createCircle(1.0);
        Circle c2 = shapeFactory.createCircle(1.0);
        System.out.println(c1 == c2);

        List<IShape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.createCircle(60.0));
        shapes.add(shapeFactory.createCircle(4.0));
        shapes.add(shapeFactory.createCircle(2.0));
        shapes.add(c1);
        shapes.add(null);
        shapes.add(c2);
        shapes.add(shapeFactory.createSquare(1.0));
        shapes.add(shapeFactory.createSquare(3.0));
        shapes.add(shapeFactory.createSquare(12.0));
        shapes.add(shapeFactory.createSquare(15.0));
        shapes.add(shapeFactory.createSquare(3.0));
        shapes.add(shapeFactory.createRectangle(10.0, 2.0));
        shapes.add(shapeFactory.createRectangle(12.0, 7.0));
        shapes.add(shapeFactory.createRectangle(1.0, 2.0));

        System.out.println(Circle.class);

        ShapeService shapeService = new ShapeService();

        System.out.println(shapeService.findTheBiggestField(shapes));
        System.out.println(shapeService.findShapeWithTheLargestCircuit(shapes, Circle.class));
        System.out.println(shapeService.findShapeWithTheLargestCircuit(shapes, Square.class));
        System.out.println(shapeService.findShapeWithTheLargestCircuit(shapes, Rectangle.class));
        //System.out.println(shapeService.findShapeWithTheLargestCircuit(shapes, null));

        //System.out.println(shapeFactory.getCirclesRegister());
        //System.out.println(shapeFactory.getRectanglesRegister());
        //System.out.println(shapeFactory.getSquaresRegister());
        System.out.println(shapes);

        shapeService.exportJsonFile(null, "src/main/resources/shapesJson.json");
        List<IShape> list2 =  shapeService.importJsonFile("src/main/resources/shapesJson.json");
        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

        System.out.println(list2);
    }
}