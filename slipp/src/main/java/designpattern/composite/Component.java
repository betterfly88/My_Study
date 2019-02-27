package designpattern.composite;

import sun.misc.CompoundEnumeration;

import java.util.ArrayList;

/**
 * Created by betterfly
 * Date : 2019.02.27
 */
public abstract class Component {
    protected Composite parent;

    public abstract void render();
    public abstract Composite getComposite();
    public void remove(){
        parent.remove(this);
    }
}

class Leaf extends Component{

    public void render() {
        System.out.println("Leaf Render !!!");
    }

    public Composite getComposite() {
        return null;
    }
}

class Composite extends Component{
    ArrayList<Component> list;
    public void render() {

    }

    public Composite getComposite() {
        return this;
    }

    public void add(Component c){
        list.add(c);
    }

    public void remove(Component c){
        list.remove(c);
    }
}

class Main{
    public static void main(String[] args) {
        Composite composite = new Composite();
        Leaf leaf = new Leaf();

        Component c = composite;
        Composite test;
        if((test = c.getComposite()) != null){

        }
    }
}
