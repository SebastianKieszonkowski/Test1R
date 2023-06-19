package pl.kurs.shapes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.kurs.shapes.models.Circle;
import pl.kurs.shapes.models.Rectangle;
import pl.kurs.shapes.models.Square;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square")})

public interface IShape {
    @JsonIgnore
    double getField();

    @JsonIgnore
    double getCircuit();
}
