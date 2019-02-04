package designpattern.prototype.capable;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class PrototypeMain {
    public static void main(String[] args) {
        PrototypeCapableDocument cloneTAndC = DocumentPrototypeManager.getCloneDocument("tandc");
        cloneTAndC.setVendorName("betterFLY");
        System.out.println(cloneTAndC);

        PrototypeCapableDocument cloneNDA = DocumentPrototypeManager.getCloneDocument("nda");
        cloneNDA.setVendorName("clone betterFLY");
        System.out.println(cloneNDA);
    }
}