package pl.kurs.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.exception.WrongInputArgumentException;
import pl.kurs.shapes.models.*;
import pl.kurs.service.ObjectMapperHolder;
import pl.kurs.service.ShapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException, WrongInputArgumentException {
        System.out.println("Zaliczyłem test");
    }
}