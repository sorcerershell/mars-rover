package marsrover;

public class MarsRover {
    public static final int RIGHT_DEGREE = 90;
    public static final int LEFT_DEGREE = -90;
    public static final String COMMAND_FORWARD = "f";
    private static final String COMMAND_BACKWARD = "b";
    private static final String COMMAND_RIGHT = "r";
    private static final String COMMAND_LEFT = "l";

    private Coordinate position;
    private Direction direction;
    private Grid grid;

    public MarsRover(Coordinate position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void rotateRight() {
        this.direction.rotate(RIGHT_DEGREE);
    }

    public void rotateLeft() {
        this.direction.rotate(LEFT_DEGREE);
    }

    public void runCommand(String commands) {
        String[] commandList = commands.split("");
        for (String command: commandList) {
            if (command.equals(MarsRover.COMMAND_FORWARD)) {
                this.moveForward();
            }

            if (command.equals(MarsRover.COMMAND_BACKWARD)) {
                this.moveBackward();
            }
            
            if (command.equals(MarsRover.COMMAND_RIGHT)) {
                this.rotateRight();
            }
            if (command.equals(MarsRover.COMMAND_LEFT)) {
                this.rotateLeft();
            }

        }
    }

    public void moveForward() {
        if (this.direction.equals(Direction.SOUTH())) {
            this.moveToSouth();
        }

        if (this.direction.equals(Direction.NORTH())) {
            this.moveToNorth();
        }

        if (this.direction.equals(Direction.WEST())) {
            this.moveToWest();
        }

        if (this.direction.equals(Direction.EAST())) {
            this.moveToEast();
        }
    }


    private void moveBackward() {
        if (this.direction.equals(Direction.SOUTH())) {
            this.moveToNorth();
        }

        if (this.direction.equals(Direction.NORTH())) {
            this.moveToSouth();
        }

        if (this.direction.equals(Direction.WEST())) {
            this.moveToEast();
        }

        if (this.direction.equals(Direction.EAST())) {
            this.moveToWest();
        }
    }

    public void moveToSouth() {
        this.moveToSouth(1);
    }

    public void moveToSouth(int step) {
        int currentPosition = this.position.getY();
        this.position.setY(currentPosition+step);
    }

    public void moveToNorth() {
        this.moveToNorth(1);
    }

    public void moveToNorth(int step) {
        int currentPosition = this.position.getY();
        this.position.setY(currentPosition-step);
    }

    public void moveToWest() {
        this.moveToWest(1);
    }

    public void moveToWest(int step) {
        int currentPosition = this.position.getX();
        this.position.setX(currentPosition-step);
    }


    public void moveToEast() {
        this.moveToEast(1);
    }

    public void moveToEast(int step) {
        int currentPosition = this.position.getX();
        this.position.setX(currentPosition+step);
    }

}
