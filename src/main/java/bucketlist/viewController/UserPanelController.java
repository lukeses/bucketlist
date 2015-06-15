/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Klasa odpowiadająca za obsługę Panelu użytkownika
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class UserPanelController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private IBucketlistDatabase database;

    private BucketlistUserInfo user;
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;

    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     *
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }
    
    /**
     * Ustawia użytkownika, na którym wykonywane są metody.
     *
     * @param user obsługiwany użytkownik
     */
    public void setUser(BucketlistUserInfo user) {
        this.user = user;
    }

    /**
     * Zwraca wartość zmiennej reprezentującej dotychczasowe hasło użytkownika
     *
     * @return wartość zmiennej przechowującej hasło
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Ustawia wartość zmiennej reprezentującej dotychczasowe hasło użytkownika
     * @param oldPassword nowa wartość zmiennej przechowującej hasło
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Zwraca wartość zmiennej reprezentującej nowe hasło użytkownika
     *
     * @return wartość zmiennej przechowującej nowe hasło
     */
    public String getNewPassword1() {
        return newPassword1;
    }

    /**
     * Ustawia wartość zmiennej reprezentującej nowe hasło użytkownika
     * @param newPassword1 nowa wartość zmiennej przechowującej nowe hasło
     */
    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    /**
     * Zwraca wartość zmiennej reprezentującej nowe hasło użytkownika. Służy
     * potwierdzeniu dwukrotnego wpisania tego samego hasła
     *
     * @return wartość zmiennej przechowującej nowe hasło
     */
    public String getNewPassword2() {
        return newPassword2;
    }

    /**
     * Ustawia wartość zmiennej reprezentującej nowe hasło użytkownika.
     * @param newPassword2 nowa wartość zmiennej przechowującej nowe hasło
     */
    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    /**
     * Zwaraca nazwę pliku ze zdjęciem profilowym użytkownika.
     *
     * @return nazwa pliku multimedialnego
     */
    public String getUserImage() {
        return user.getUserImage();
    }

    /**
     * Metoda próbująca zmienić hasło użytkownika. Funkcja sprawdza czy
     * wprowadzone hasło zgadza się z dotychczasowym oraz czy propozycje nowego
     * hasła są identyczne
     */
    public void tryToChangePassword() {
        String resultMsg = null;
        FacesContext context = FacesContext.getCurrentInstance();
        if (user != null && newPassword1.equals(newPassword2)) {
            if (!user.changePassword(oldPassword, newPassword1)) {
                resultMsg = "Some error occured.";
            } else {
                database.openSession();
                database.changePassword(user.getId(), newPassword1);
                database.closeSession();
                resultMsg = "The operation was successfull.";
            }
        } else {
            resultMsg = "Some error occured.";
        }
        FacesMessage msg = new FacesMessage(resultMsg, "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        if (context != null) {
            context.addMessage(null, msg);
        }
    }

    /**
     * Metoda służy do usuwania konta użytkownika z bazy danych. Metoda sprawdza
     * czy podane hasło jest prawidłowe w celu potwierdzenai tożsamości
     * użytkownika i usuwa go z bazy danych.
     *
     * @return przekierowanie
     */
    public String tryToDeleteUser() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (user != null) {
            database.openSession();
            int passwordCheck = database.checkPassword(user.getEmail(), oldPassword);
            database.closeSession();
            if (passwordCheck == user.getId()) {
                database.openSession();
                database.deleteUser(passwordCheck);
                database.closeSession();
                if (login != null) {
                    login.logout();
                    return "/logpanel.xhtml?faces-redirect=true";
                }

            } else {
                FacesMessage msg = new FacesMessage("Some error occured.", "ERROR MSG");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                if (context != null) {
                    context.addMessage(null, msg);
                }
            }
        }
        return null;
    }

    /**
     * Inicjalizuje klasę obsługującą funkcje panelu, pobierając dane
     * użytkownika aktualnej sesji.
     */
    public void init() {
        int userId = 0;
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            userId = (int) session.getAttribute("userId");
        }
        if (userId > 0) {
            database.openSession();
            this.user = database.getUser(userId);
            database.closeSession();
        } else {
            FacesMessage msg = new FacesMessage("Some error occured.", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            if (context != null) {
                context.addMessage(null, msg);
            }
        }

    }

    /**
     * Miejsce wstrzyknięcia klasy obsługującej sesję
     *
     * @param login obiekt do wstrzyknięcia
     */
    public void setLogin(LoginController login) {
        this.login = login;
    }
}
