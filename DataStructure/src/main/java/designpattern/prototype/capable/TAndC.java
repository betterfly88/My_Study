package designpattern.prototype.capable;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class TAndC extends PrototypeCapableDocument {
    @Override
    public PrototypeCapableDocument cloneDocument() throws CloneNotSupportedException {
        TAndC tAndC = null;
        try{
            tAndC = (TAndC)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        return tAndC;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
