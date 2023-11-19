package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public MapDirection next() {
        int nextOrdinal = (this.ordinal() + 1) % values().length;
        return values()[nextOrdinal];
    }

    public MapDirection previous() {
        int previousOrdinal = (this.ordinal() + values().length - 1) % values().length;
        return values()[previousOrdinal];
    }
    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
        };
    }
}

