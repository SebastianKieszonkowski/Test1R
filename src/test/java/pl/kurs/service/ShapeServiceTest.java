package pl.kurs.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.models.Circle;
import pl.kurs.models.IShape;
import pl.kurs.models.Rectangle;
import pl.kurs.models.ShapeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import org.assertj.core.api.SoftAssertions;

public class ShapeServiceTest {

    List<IShape> shapes = new ArrayList<>();
    ShapeFactory shapeFactory = new ShapeFactory();
    ShapeService shapeService = new ShapeService();

    @Before
    public void init(){
        shapes.add(shapeFactory.createCircle(32.0));
        shapes.add(shapeFactory.createCircle(12.0));
        shapes.add(shapeFactory.createSquare(7.0));
        shapes.add(shapeFactory.createRectangle(10.0, 2.0));
        shapes.add(shapeFactory.createRectangle(12.0, 7.0));
        shapes.add(shapeFactory.createSquare(12.0));
        shapes.add(shapeFactory.createCircle(2.0));
        shapes.add(shapeFactory.createSquare(1.0));
        shapes.add(shapeFactory.createSquare(15.0));
        shapes.add(shapeFactory.createSquare(3.0));
        shapes.add(shapeFactory.createRectangle(1.0, 4.0));
    }

    @Test
    public void findTheBiggestFieldMethodFromShapesListShouldReturnCircleWithRadius32() {
        //given

        //when
        IShape shapesWithTheBiggestField = shapeService.findTheBiggestField(shapes);
        //then
        assertSame(shapes.get(0), shapesWithTheBiggestField);
    }

    @Test
    public void findTheBiggestFieldMethodShouldThrowNullPointExceptionWhenShapesListIsEmpty() {
        //given

        //when
        Exception e = assertThrows(NullPointerException.class, () -> shapeService.findTheBiggestField(null));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
        sa.assertThat(e).hasMessage("Przekazana w argumencie lista jest pusta!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void findTheBiggestFieldMethodShouldThrowNoSuchElementExceptionWhenAllShapesListElementsWillBeNulls() {
        //given
        List<IShape> shapes2 = new ArrayList<>();
        shapes2.add(null);
        //when
        Exception e = assertThrows(NoSuchElementException.class, () -> shapeService.findTheBiggestField(shapes2));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NoSuchElementException.class);
        sa.assertThat(e).hasMessage("Nie ma takiego elementu!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void findShapeWithTheLargestCircuitMethodFromShapesListShouldReturnRectangleLength12Wight7ForRectangle() {
        //givene

        //when
        IShape shapesWithTheLargestCircuit = shapeService.findShapeWithTheLargestCircuit(shapes, Rectangle.class);
        //then
        assertSame(shapes.get(4), shapesWithTheLargestCircuit);
    }

    @Test
    public void findShapeWithTheLargestCircuitMethodShouldThrowNullPointExceptionWhenShapesListIsEmpty() {
        //given

        //when
        Exception e = assertThrows(NullPointerException.class, () -> shapeService.findShapeWithTheLargestCircuit(null, Circle.class));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
        sa.assertThat(e).hasMessage("Przekazana w argumencie lista jest pusta!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void findShapeWithTheLargestCircuitMethodShouldThrowNoSuchElementExceptionWhenAllShapesListElementsWillBeNulls() {
        //given
        List<IShape> shapes2 = new ArrayList<>();
        shapes2.add(null);
        //when
        Exception e = assertThrows(NoSuchElementException.class, () -> shapeService.findShapeWithTheLargestCircuit(shapes2, Circle.class));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NoSuchElementException.class);
        sa.assertThat(e).hasMessage("Nie ma takiego elementu!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void findShapeWithTheLargestCircuitMethodShouldThrowNoSuchElementExceptionWhenInputTypeWillBeMismatched() {
        //given

        //when
        Exception e = assertThrows(NoSuchElementException.class, () -> shapeService.findShapeWithTheLargestCircuit(shapes, Object.class));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NoSuchElementException.class);
        sa.assertThat(e).hasMessage("Nie ma takiego elementu!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void exportJsonFileMethod() {
        //given

        //when
        Exception e = assertThrows(NullPointerException.class, () -> shapeService.exportJsonFile(null,"src/main/resources/shapesJsonTest.json"));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
        sa.assertThat(e).hasMessage("Jeden z argumentow jest niewlasciwy, lub oba!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void exportJsonFileMethod2() {
        //given

        //when
        Exception e = assertThrows(NullPointerException.class, () -> shapeService.exportJsonFile(shapes,null));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
        sa.assertThat(e).hasMessage("Jeden z argumentow jest niewlasciwy, lub oba!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void importJsonFile() throws IOException {

    }
}