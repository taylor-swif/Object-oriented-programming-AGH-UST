package agh.ics.oop.model;

import java.util.Objects;

public record Vector2d(int x, int y) {

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        return new Vector2d(newX, newY);
    }

    public Vector2d subtract(Vector2d other) {
        int newX = this.x - other.x;
        int newY = this.y - other.y;
        return new Vector2d(newX, newY);
    }

    public Vector2d upperRight(Vector2d other) {
        int newX = Math.max(this.x, other.x);
        int newY = Math.max(this.y, other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int newX = Math.min(this.x, other.x);
        int newY = Math.min(this.y, other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d opposite() {
        int newX = -this.x;
        int newY = -this.y;
        return new Vector2d(newX, newY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x() == vector2d.x() && y() == vector2d.y();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x(), y());
    }
}
