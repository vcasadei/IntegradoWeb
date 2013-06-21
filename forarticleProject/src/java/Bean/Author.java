/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Ian
 */
public class Author {

    public Author() {
    }

    public String getForeName() {
        return foreName;
    }

    public Author(String foreName, String lastName, String initials) {
        this.foreName = foreName;
        this.lastName = lastName;
        this.initials = initials;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    private String foreName;
    private String lastName;
    private String initials;
}
