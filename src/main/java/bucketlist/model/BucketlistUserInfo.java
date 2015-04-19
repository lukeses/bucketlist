/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

//import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class BucketlistUserInfo {
    private int id;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    private Date lastLogin;
    private String email;
    private String passwordHash;
    private List<BucketlistListItem> listItems;
    
    public BucketlistUserInfo(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = password; //not hashed yet
        this.registrationDate = new Date();
        this.listItems = new ArrayList<BucketlistListItem>();
    }
    
    public BucketlistUserInfo(String email, String password) {
        this(null, null, email, password);
    }
    
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.passwordHash.equals(oldPassword))
            this.passwordHash = newPassword;
        else return false;
        
        return true;
    }

    public List<BucketlistListItem> getListItems() {
        return listItems;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setListItems(List<BucketlistListItem> listItems) {
        this.listItems = listItems;
    }

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
}
