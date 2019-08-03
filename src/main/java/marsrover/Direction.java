package marsrover;

public class Direction {
    public static final int FULL_CIRCLE = 360;
    private  int facing = 0;
    static int NORTH = 0;
    static int EAST = 90;
    static int SOUTH = 180;
    static int WEST = 270;
    static String DEGREE_0 = "NORTH";
    static String DEGREE_90 = "EAST";
    static String DEGREE_180 = "SOUTH";
    static String DEGREE_270 = "WEST";

    private Direction(int facing) {
        this.facing = facing;
    }

    public static Direction NORTH() {
        return new Direction(Direction.NORTH);
    }

    public static Direction EAST() {
        return new Direction(Direction.EAST);
    }

    public static Direction SOUTH() {
        return new Direction(Direction.SOUTH);
    }

    public static Direction WEST() {
        return new Direction(Direction.WEST);
    }

    public int getFacing() {
        return this.facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return facing == direction.facing;
    }

    @Override
    public int hashCode() {
        return facing;
    }

    public void rotate(int degree) {
        this.facing += degree;

        if (this.facing < 0) {
            this.facing = FULL_CIRCLE + this.facing;
        }

        if (this.facing >= FULL_CIRCLE) {
            this.facing = this.facing - FULL_CIRCLE;
        }

    }

    @Override
    public String toString() {
        switch (this.facing) {
            case 0:
                return Direction.DEGREE_0;
            case 90:
                return Direction.DEGREE_90;
            case 180:
                return Direction.DEGREE_180;
            case 270:
                return Direction.DEGREE_180;
            default:
                return "Degree: " + String.valueOf(this.facing);
        }
    }
}
