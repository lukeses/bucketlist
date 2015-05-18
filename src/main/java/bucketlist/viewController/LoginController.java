/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Klasa obsługująca żądania ze strony logpanel.xhtml
 * oraz zachowująca stan sesji użytkownika.
 * @author Daniel
 */

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {


    @ManagedProperty (value = "#{databaseDAO}")
    private BucketlistController database;
    private String userName;
    private String userPassword;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }

    /**
     * Zwraca aktualną wartość pola userName
     * @return adres email
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Ustawia aktualną wartość pola userName
     * @param userName adres email
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Zwraca aktualną wartość pola userPassword
     * @return hasło
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Ustawia aktualną wartość pola userPassword
     * @param userPassword hasło
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private boolean loggedIn;

    /**
     * Funkcja podejmująca próbę zalgowania użytkownika.
     * Weryfikuje poprawność wprowadzonych danych
     * @return przekierowanie na odpowiednią stronę
     */
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

    /**
     * Funkcja wylogowująca użytkownika
     * @return przekierowanie na odpowiednią stronę
     */
    public String logout() {
        loggedIn = false;

        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "/logpanel.xhtml?faces-redirect=true";
    }

    /**
     * Funkcja sprawdzająca stan sesji użytkownika, czy jest zalogowany.
     * @return czy jest zalogowany
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
