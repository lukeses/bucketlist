/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

//import javax.persistence.Entity;
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

    public List<BucketlistListItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<BucketlistListItem> listItems) {
        this.listItems = listItems;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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
