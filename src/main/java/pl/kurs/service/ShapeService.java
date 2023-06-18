package pl.kurs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import pl.kurs.exception.WrongInputArgumentException;
import pl.kurs.shapes.IShape;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ShapeService {

    private ObjectMapper objectMapper;

    public ShapeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public IShape findTheBiggestField(List<IShape> list) {
        return Optional.ofNullable(list)
                .orElseThrow(() -> new NullPointerException("Przekazana w argumencie lista jest pusta!!!"))
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(IShape::getField))
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elementu!!!"));
    }

    public IShape findShapeWithTheLargestCircuit(List<IShape> list, Class tClass) {
        return Optional.ofNullable(list)
                .orElseThrow(() -> new NullPointerException("Przekazana w argumencie lista jest pusta!!!"))
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getClass().equals(tClass))
                .max(Comparator.comparing(IShape::getCircuit))
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elementu!!!"));
    }

    public void exportJsonFile(List<IShape> list, String path) throws IOException, WrongInputArgumentException {
        if (list == null | path == null)
            throw new WrongInputArgumentException("Jeden z argumentow jest niewlasciwy, lub oba!!!");

        ArrayNode jsonArray = objectMapper.createArrayNode();
        for (IShape e : list) {
            jsonArray.add(objectMapper.valueToTree(e));
        }
        objectMapper.writeValue(new File(path), jsonArray);
    }

    public List<IShape> importJsonFile(String path) throws WrongInputArgumentException, IOException {
        if (path == null)
            throw new WrongInputArgumentException("Argument jest nullem!!!");

        return objectMapper.readValue(new File(path), objectMapper.getTypeFactory()
                .constructCollectionType(List.class, IShape.class));
    }
}
