/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBanco;

/**
 *
 * @author Ian
 */
public class MeshHeading {

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public MeshHeading() {
    }

    public MeshHeading(String descriptionName) {
        this.descriptionName = descriptionName;
    }
    
    private String descriptionName;
}
