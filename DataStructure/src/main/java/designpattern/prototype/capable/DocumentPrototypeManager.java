package designpattern.prototype.capable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class DocumentPrototypeManager {
    private static Map<String, PrototypeCapableDocument> prototypes = new HashMap<>();
    static {
        TAndC tAndC = new TAndC();
        tAndC.setVendorName("VendorName - Placeholder");
        tAndC.setContent("Please read and accept the terms and conditions....");
        prototypes.put("tandc", tAndC);

        AuthorizedSignatory authorizedSignatory = new AuthorizedSignatory();
        authorizedSignatory.setName("Andrew Clark");
        authorizedSignatory.setDesignation("Operation Head");

        NDAgreement nda = new NDAgreement();
        nda.setVendorName("VendorName - Placeholder");
        nda.setContent("Please read and accept thd NDA...");
        nda.setAuthorizedSignatory(authorizedSignatory);
        prototypes.put("nda", nda);
    }

    public static PrototypeCapableDocument getCloneDocument(final String type){
        PrototypeCapableDocument cloneDoc = null;
        try{
            PrototypeCapableDocument doc = prototypes.get(type);
            cloneDoc = doc.cloneDocument();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return cloneDoc;
    }
}
