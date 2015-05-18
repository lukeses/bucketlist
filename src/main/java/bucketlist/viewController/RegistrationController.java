/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class RegistrationController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private BucketlistController database;
    private String firstName;
    private String lastName;
    private String password1;
    private String password2;
    private String email1;
    private String email2;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    /**
     * @param database the database to set
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }
    
    public String registerNewUser() {
        boolean result = false;
        if (email1.equals(email2))
            if (password1.equals(password2)) {
                database.openSession();
                if (!database.userExists(email1))
                    result = true;
                database.closeSession();
            }
        
        if (result) {
            database.openSession();
            database.addNewUser(firstName, lastName, email1, password1);
            database.closeSession();
            
            return "/logpanel.xhtml?faces-redirect=true";   
        }
        FacesMessage msg = new FacesMessage("Registration error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
}
