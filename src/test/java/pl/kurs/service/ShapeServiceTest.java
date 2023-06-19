package pl.kurs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kurs.exception.WrongInputArgumentException;
import pl.kurs.shapes.models.Circle;
import pl.kurs.shapes.models.IShape;
import pl.kurs.shapes.models.Rectangle;
import pl.kurs.shapes.models.ShapeFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import org.assertj.core.api.SoftAssertions;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ShapeServiceTest {

    List<IShape> shapes = new ArrayList<>();
    ShapeFactory shapeFactory = new ShapeFactory();
    ObjectMapper objectMapper =ObjectMapperHolder.INSTANCE.getObjectMapper();
    ShapeService shapeService = new ShapeService(objectMapper);

    @Mock
    private ObjectMapper objectMapperMock;
    @InjectMocks
    ShapeService shapeServiceMock;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
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
        IShape shapesWithTheBiggestField = shapeServiceMock.findTheBiggestField(shapes);
        //then
        assertSame(shapes.get(0), shapesWithTheBiggestField);
    }

    @Test
    public void findTheBiggestFieldMethodShouldThrowNullPointExceptionWhenShapesListIsEmpty() {
        //given

        //when
        Exception e = assertThrows(NullPointerException.class, () -> shapeServiceMock.findTheBiggestField(null));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
        sa.assertThat(e).hasMessage("Przekazana w argumencie lista jest nullem!!!");
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
        Exception e = assertThrows(NoSuchElementException.class, () -> shapeServiceMock.findTheBiggestField(shapes2));

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
        IShape shapesWithTheLargestCircuit = shapeServiceMock.findShapeWithTheLargestCircuit(shapes, Rectangle.class);
        //then
        assertSame(shapes.get(4), shapesWithTheLargestCircuit);
    }

    @Test
    public void findShapeWithTheLargestCircuitMethodShouldThrowNullPointExceptionWhenShapesListIsEmpty() {
        //given

        //when
        Exception e = assertThrows(NullPointerException.class, () -> shapeServiceMock.findShapeWithTheLargestCircuit(null, Circle.class));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
        sa.assertThat(e).hasMessage("Przekazana w argumencie lista jest nullem!!!");
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
        Exception e = assertThrows(NoSuchElementException.class, () -> shapeServiceMock.findShapeWithTheLargestCircuit(shapes2, Circle.class));

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
        Exception e = assertThrows(NoSuchElementException.class, () -> shapeServiceMock.findShapeWithTheLargestCircuit(shapes, Object.class));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(NoSuchElementException.class);
        sa.assertThat(e).hasMessage("Nie ma takiego elementu!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }
    @Test
    public void exportJsonFileMethodShouldVerifyCreatingJsonFileProcess() throws IOException, WrongInputArgumentException {
        //given
        String path = "test.json";
        List<IShape> shapeExportList = new ArrayList<>();
        shapeExportList.add(shapeFactory.createCircle(31.0));
        shapeExportList.add(shapeFactory.createCircle(12.0));
        ArrayNode jsonNode = objectMapper.createArrayNode();
        when(objectMapperMock.createArrayNode()).thenReturn(jsonNode);

        //when
        shapeServiceMock.exportJsonFile(shapeExportList, path);

        //then
        verify(objectMapperMock, times(1)).createArrayNode();
        verify(objectMapperMock, times(2)).valueToTree(any(IShape.class));
        verify(objectMapperMock, times(1)).writeValue(any(File.class), any());
    }
    @Test
    public void exportJsonFileMethodShouldThrowWrongInputArgumentExceptionWhenListIsNull() {
        //given

        //when
        Exception e = assertThrows(WrongInputArgumentException.class, () -> shapeServiceMock.exportJsonFile(null,"src/main/resources/shapesJsonTest.json"));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(WrongInputArgumentException.class);
        sa.assertThat(e).hasMessage("Jeden z argumentow jest niewlasciwy, lub oba!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void exportJsonFileMethodShouldThrowWrongInputArgumentExceptionWhenPathIsNull() {
        //given

        //when
        Exception e = assertThrows(WrongInputArgumentException.class, () -> shapeServiceMock.exportJsonFile(shapes,null));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(WrongInputArgumentException.class);
        sa.assertThat(e).hasMessage("Jeden z argumentow jest niewlasciwy, lub oba!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }

    @Test
    public void importJsonFileMethodShouldReturnListTheSameShapesList() throws IOException, WrongInputArgumentException {
        //given

        //when
        List<IShape> resultListShapes = shapeService.importJsonFile("src/main/resources/shapesJsonTest.json");
        //then
        assertEquals(shapes, resultListShapes);
    }

    @Test
    public void importJsonFileMethodShouldThrowWrongInputArgumentExceptionWhenPathIsNull()  {
        //given

        //when
        Exception e = assertThrows(WrongInputArgumentException.class, () -> shapeServiceMock.importJsonFile(null));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(WrongInputArgumentException.class);
        sa.assertThat(e).hasMessage("Argument jest nullem!!!");
        sa.assertThat(e).hasNoCause();
        sa.assertThat(e).hasFieldOrProperty("message");
        sa.assertAll();
    }
}