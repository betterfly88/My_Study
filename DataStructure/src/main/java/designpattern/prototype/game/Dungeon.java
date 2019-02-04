package designpattern.prototype.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class Dungeon implements Cloneable{
    private String name;
    private List<Monster> monsterList = new ArrayList<>();

    @Override
    public String toString() {
        return "Dungeon{" +
                "name='" + name + '\'' +
                ", monsterList=" + monsterList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public void loadMonster(){
        for(int i=0; i<10; i++){
            Monster m = new Monster();
            m.setName("Monster_"+i);
            m.setHp(i * 100);
            this.getMonsterList().add(m);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
