package designpattern.prototype.gof;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public interface MazeFactory {
    public Maze makeMaze() throws CloneNotSupportedException;
    public Room makeRoom(int count);
    public Wall makeWall();
    public Door makeDoor(Room r1, Room r2);

}
