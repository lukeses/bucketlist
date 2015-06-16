/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistMail;
import bucketlist.controller.IBucketlistDatabase;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import bucketlist.controller.BucketlistMail;
/**
 * Klasa obsługująca żądania ze strony regpanel.xhtml.
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class RegistrationController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private IBucketlistDatabase database;
    private String firstName;
    private String lastName;
    private String password1;
    private String password2;
    private String email1;
    private String email2;

    /**
     * Zwraca wartość pola firstName
     * @return imię
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Ustawia wartość pola firstName
     * @param firstName imię
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Zwraca wartość pola lastName
     * @return nazwisko
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Ustawia wartość pola lastName
     * @param lastName nazwisko
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Zwraca wartość pola password1
     * @return hasło
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * Ustawia wartość pola password1
     * @param password1 hasło
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * Zwraca wartość pola password2
     * @return hasło
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * Ustawia wartość pola password2
     * @param password2 hasło
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * Zwraca wartość pola email1
     * @return email
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * Ustawia wartość pola email1
     * @param email1 email
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    /**
     * Zwraca wartość pola email2
     * @return email
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * Ustawia wartość pola email2
     * @param email2 email
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }
    
    /**
     * Funkcja rejestruje nowego użytkownika
     * @return odpowiednie przekierowanie na stronę
     */
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
     
            //BucketlistMail bucketlistMail = new BucketlistMail();
            //String email_message = "Witaj, " + firstName + ",\n\n Nadałeś hasło użytkownika: " + password1;
            //bucketlistMail.sendMail(email1, email_message, "Rejestracja użytkownika");
            
            return "/logpanel.xhtml?faces-redirect=true";   
        }
        FacesMessage msg = new FacesMessage("Registration error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext context = FacesContext.getCurrentInstance();
        if (context!= null)
            context.addMessage(null, msg);
        return null;
    }
}
