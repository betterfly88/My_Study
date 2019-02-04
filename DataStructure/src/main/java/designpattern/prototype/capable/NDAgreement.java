package designpattern.prototype.capable;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class NDAgreement extends PrototypeCapableDocument{
    private AuthorizedSignatory authorizedSignatory;

    public AuthorizedSignatory getAuthorizedSignatory() {
        return authorizedSignatory;
    }

    public void setAuthorizedSignatory(AuthorizedSignatory authorizedSignatory) {
        this.authorizedSignatory = authorizedSignatory;
    }

    @Override
    public String toString() {
        return "NDAgreement{" +
                "authorizedSignatory=" + authorizedSignatory +
                '}';
    }


    @Override
    public PrototypeCapableDocument cloneDocument() throws CloneNotSupportedException {
        NDAgreement nda;
        nda = (NDAgreement) super.clone();
        AuthorizedSignatory clonedAuth = (AuthorizedSignatory) nda.getAuthorizedSignatory().clone();
        nda.setAuthorizedSignatory(clonedAuth);

        return nda;
    }
}
