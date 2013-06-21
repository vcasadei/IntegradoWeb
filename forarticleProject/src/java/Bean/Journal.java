/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Ian
 */
public class Journal {
    
    public String getISSN() {
        return ISSN;
    }

    public Journal(String ISSN, String title, String abreviation, String nlmUniqueID) {
        this.ISSN = ISSN;
        this.title = title;
        this.abreviation = abreviation;
        this.nlmUniqueID = nlmUniqueID;
    }

    public Journal() {
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getNlmUniqueID() {
        return nlmUniqueID;
    }

    public void setNlmUniqueID(String nlmUniqueID) {
        this.nlmUniqueID = nlmUniqueID;
    }
    
    private String ISSN;
    private String title;
    private String abreviation;
    private String nlmUniqueID;
}
