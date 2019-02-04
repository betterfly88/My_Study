package designpattern.prototype.gof;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class MazePrototypeFactory implements MazeFactory, Cloneable{
    private Maze protoTypeMaze;
    private Wall protoTypeWall;
    private Room protoTypeRoom;
    private Door protoTypeDoor;

    public MazePrototypeFactory(Maze _maze, Wall _wall, Room _room, Door _door){
        this.protoTypeMaze = _maze;
        this.protoTypeWall = _wall;
        this.protoTypeRoom = _room;
        this.protoTypeDoor = _door;
    }

    @Override
    public Maze makeMaze() throws CloneNotSupportedException{
        return (Maze)protoTypeMaze.clone();
    }

    @Override
    public Room makeRoom(int count){
        return null;
    }

    @Override
    public Wall makeWall() {
        return null;
    }

    @Override
    public Door makeDoor(Room r1, Room r2){
        Door door = (Door)protoTypeDoor.clone();

        return door;
    }
}
