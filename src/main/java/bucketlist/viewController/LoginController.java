/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
@SessionScoped
@Named
public class LoginController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private BucketlistController database;
    private String userName;
    private String userPassword;

    /**
     * @param database the database to set
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private boolean loggedIn;

    public String tryToLogin() {
        database.openSession();
        int id = database.checkPassword(userName, userPassword);
        database.closeSession();
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("userId", id);

        if (id != -1) {
            loggedIn = true;
            return "/secured/userItems.xhtml?faces-redirect=true";
        }
        
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }

    public String logout() {
        loggedIn = false;

        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "/logpanel.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
