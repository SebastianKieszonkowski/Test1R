package pl.kurs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import pl.kurs.models.Circle;
import pl.kurs.models.IShape;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ShapeService {

    private ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

    public IShape findTheBiggestField(List<IShape> list) {
        return Optional.ofNullable(list)
                .orElseThrow(() -> new NullPointerException("Lista pusta"))
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(IShape::getField))
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elementu"));
    }

    public IShape findShapeWithTheLargestCircuit(List<IShape> list, Class tClass) {
        return Optional.ofNullable(list)
                .orElseThrow(() -> new NullPointerException("Lista pusta"))
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getClass().equals(tClass))
                .max(Comparator.comparing(IShape::getCircuit))
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elementu"));
    }

    public void exportJsonFile(List<IShape> list, String path) {
        ArrayNode jsonArray = objectMapper.createArrayNode();
        for (IShape e : list) {
            jsonArray.add(objectMapper.valueToTree(e));
        }
        try {
            objectMapper.writeValue(new File(path), jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<IShape> importJsonFile(String path) {
        List<IShape> list = null;
        try {
            list = objectMapper.readValue(new File(path), objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, IShape.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
