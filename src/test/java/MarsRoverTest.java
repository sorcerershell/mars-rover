import marsrover.Location;
import marsrover.Direction;
import marsrover.Grid;
import marsrover.MarsRover;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    @Test
    public void it_ShouldBe_PositionedAt_0_0_And_FaceNorth() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        assertEquals(Location.at(0, 0), marsRover.getLocation());
        assertEquals(Direction.NORTH(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingEast_Given_RotatedTo_Right() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.rotateRight();
        assertEquals(Direction.EAST(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingSouth_Given_RotatedTo_RightTwice() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.rotateRight();
        marsRover.rotateRight();
        assertEquals(Direction.SOUTH(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingWest_Given_RotatedTo_Left() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.rotateLeft();
        assertEquals(Direction.WEST(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingSouth_Given_RotatedTo_LeftTwice() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.rotateLeft();
        marsRover.rotateLeft();
        assertEquals(Direction.SOUTH(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingNorth_Given_RotatedTo_LeftFourTimes() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.rotateLeft();
        marsRover.rotateLeft();
        marsRover.rotateLeft();
        marsRover.rotateLeft();
        assertEquals(Direction.NORTH(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingNorth_Given_RotatedTo_RightFourTimes() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.rotateRight();
        marsRover.rotateRight();
        marsRover.rotateRight();
        marsRover.rotateRight();
        assertEquals(Direction.NORTH(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_0_1_Given_PlacedAt_0_0_FacingSouth_And_MoveForward_Once() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.SOUTH(), Grid.create(100, 100));
        marsRover.moveForward();
        assertEquals(Location.at(0, 1), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_0_2_Given_PlacedAt_0_0_FacingSouth_And_MoveForward_Twice() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.SOUTH(), Grid.create(100, 100));
        marsRover.moveForward();
        marsRover.moveForward();
        assertEquals(Location.at(0, 2), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_0_5_Given_PlacedAt_0_0_FacingSouth_And_MoveForward_5times() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.SOUTH(), Grid.create(100, 100));
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        assertEquals(Location.at(0, 5), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_10_5_Given_PlacedAt_10_10_FacingNorth_And_MoveForward_5times() {
        MarsRover marsRover = new MarsRover(Location.at(10, 10), Direction.NORTH(), Grid.create(100, 100));
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        assertEquals(Location.at(10, 5), marsRover.getLocation());
    }



    @Test
    public void it_ShouldBe_MovedToLocation_5_10_Given_PlacedAt_10_10_FacingWest_And_MoveForward_5times() {
        MarsRover marsRover = new MarsRover(Location.at(10, 10), Direction.WEST(), Grid.create(100, 100));
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        assertEquals(Location.at(5, 10), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_5_10_Given_PlacedAt_0_10_FacingEast_And_MoveForward_5times() {
        MarsRover marsRover = new MarsRover(Location.at(0, 10), Direction.EAST(), Grid.create(100, 100));
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        marsRover.moveForward();
        assertEquals(Location.at(5, 10), marsRover.getLocation());
    }


    @Test
    public void it_ShouldBe_MovedToLocation_0_10_Given_PlacedAt_0_0_FacingSouth_And_RunCommand_FFFFF() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.SOUTH(), Grid.create(100, 100));
        marsRover.runCommand("fffff");
        assertEquals(Location.at(0, 5), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_10_5_Given_PlacedAt_10_10_FacingNorth_And_RunCommand_FFFFF() {
        MarsRover marsRover = new MarsRover(Location.at(10, 10), Direction.NORTH(), Grid.create(100, 100));
        marsRover.runCommand("fffff");
        assertEquals(Location.at(10, 5), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_10_5_Given_PlacedAt_10_10_FacingSouth_And_RunCommand_BBBBB() {
        MarsRover marsRover = new MarsRover(Location.at(10, 10), Direction.SOUTH(), Grid.create(100, 100));
        marsRover.runCommand("bbbbb");
        assertEquals(Location.at(10, 5), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_10_5_Given_PlacedAt_10_10_FacingEast_And_RunCommand_BBBBB() {
        MarsRover marsRover = new MarsRover(Location.at(10, 10), Direction.EAST(), Grid.create(100, 100));
        marsRover.runCommand("bbbbb");
        assertEquals(Location.at(5, 10), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_0_5_Given_PlacedAt_0_0_FacingNorth_And_RunCommand_BBBBB() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.runCommand("bbbbb");
        assertEquals(Location.at(0, 5), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_5_0_Given_PlacedAt_0_0_FacingWest_And_RunCommand_BBBBB() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.WEST(), Grid.create(100, 100));
        marsRover.runCommand("bbbbb");
        assertEquals(Location.at(5, 0), marsRover.getLocation());
    }

    @Test
    public void it_ShouldBe_FacingEast_Given_FacingNorth_And_RunCommand_R() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.runCommand("r");
        assertEquals(Direction.EAST(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_FacingWest_Given_FacingNorth_And_RunCommand_L() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.NORTH(), Grid.create(100, 100));
        marsRover.runCommand("l");
        assertEquals(Direction.WEST(), marsRover.getDirection());
    }

    @Test
    public void it_ShouldBe_MovedToLocation_2_2_Given_PlacedAt_0_0_FacingSouth_And_RunCommand_FFLFF() {
        MarsRover marsRover = new MarsRover(Location.at(0, 0), Direction.SOUTH(), Grid.create(100, 100));
        marsRover.runCommand("fflff");
        assertEquals(Location.at(2, 2), marsRover.getLocation());
    }
}
