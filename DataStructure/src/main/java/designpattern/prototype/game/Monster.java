package designpattern.prototype.game;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class Monster {
    private String name;
    private int hp;

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
