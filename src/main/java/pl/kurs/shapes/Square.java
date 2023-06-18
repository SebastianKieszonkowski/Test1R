package pl.kurs.shapes;

import java.util.Objects;

//@JsonTypeName("square")
public class Square implements IShape {

    private double side;

    private Square() {
    }

    protected Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getField() {
        return Math.pow(side, 2.0);
    }

    @Override
    public double getCircuit() {
        return 4 * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
