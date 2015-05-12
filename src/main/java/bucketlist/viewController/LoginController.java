/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.model.BucketlistListItem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class LoginController {
    @ManagedProperty (value = "#{databaseDAO}") 
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
    
    public String tryToLogin() {
        database.openSession();
        database.getUserByEmail(userName);
        boolean result = database.checkPassword(userName, userPassword);
        database.CloseSession();
        
        if (result)
            return "userItems.xhtml";
        else return "logpanel.jsp";
    }
    
}
