/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBanco;

/**
 *
 * @author Ian
 */
public class PublicationType {

    public String getTypeName() {
        return typeName;
    }

    public PublicationType() {
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public PublicationType(String typeName) {
        this.typeName = typeName;
    }
    
    private String typeName;
}
