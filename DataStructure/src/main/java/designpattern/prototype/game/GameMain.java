package designpattern.prototype.game;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class GameMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Dungeon d = new Dungeon();
        d.setName("First Dungeon");
        d.loadMonster();

        Dungeon d2 = (Dungeon)d.clone();
//        Dungeon d2 = d;
        d2.setName("Second Dungeon");
        d.getMonsterList().remove(2);

        System.out.println(d);
        System.out.println(d2);
    }
}