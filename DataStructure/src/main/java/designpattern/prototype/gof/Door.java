package designpattern.prototype.gof;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class Door implements Cloneable{
    private Room _room1;
    private Room _room2;

    public Door(Door d){

    }

    public Door clone(){
        return new Door(this);
    }

    public void initialize(Room r1, Room r2){
        _room1 = r1;
        _room2 = r2;
    }
    public void enter(){

    }

    public Room otherSideFrom(Room r){
        return r;
    }
}
