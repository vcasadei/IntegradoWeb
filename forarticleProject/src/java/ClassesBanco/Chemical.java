/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBanco;

/**
 *
 * @author Ian
 */
public class Chemical {

    public String getChemicalName() {
        return chemicalName;
    }

    public Chemical() {
    }

    public Chemical(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }
    
    private String chemicalName;
}
