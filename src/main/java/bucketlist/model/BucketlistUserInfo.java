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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Klasa reprezentująca użytkownika. Zawiera ogólne informacje o użytkownika i
 * dane potrzebne do logowania. Obiekt klasy tworzony jest przy rejestracji 
 * nowego użytkownika.
 * @author Daniel
 */
@ManagedBean (name = "user")
@RequestScoped
public class BucketlistUserInfo {
    private int id;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    private Date lastLogin;
    private String email;
    private String passwordHash;
    private List<BucketlistListItem> listItems;
    
    /**
     * Kompletny kontruktor klasy. Przyjmuje jako parametry kompletny zestaw
     * informacji o użytkowniku.
     * @param firstName imię użytkownika, maksymalnie 45 znaków
     * @param lastName nazwisko użytkownika, maksymalnie 45 znaków
     * @param email adres email użytkownika, maksymalnie 45 znaków
     * @param password hasło użytkownika, maksymalnie 45 znaków
     */
    public BucketlistUserInfo(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = password; //not hashed yet
        this.registrationDate = new Date();
        this.listItems = new ArrayList<BucketlistListItem>();
    }
    
    /**
     * Konstruktor przyjmujący jako parametry minimalny zestaw informacji
     * o użytkowniku. Informacje te używane są przy logowaniu.
     * @param email adres email użytkownika
     * @param password hasło użytkownika
     */
    public BucketlistUserInfo(String email, String password) {
        this(null, null, email, password);
    }
    
    /**
     * Domyślny kontruktor. Nie powinien być używany, jest wymagany przez
     * Hibernate. 
     */
    public BucketlistUserInfo() {
        
    }
    
    /**
     * Metoda służąca do zmiany hasła użytkownika. Metoda zmienia hasło na podane
     * w parametrze newPassword tylko, jeżeli parametr oldPassword jest taki sam
     * jak dotychczasowe hasło użytkownika.
     * @param oldPassword dotychczasowe hasło użytkownika
     * @param newPassword nowe hasło użytkownika
     * @return zwraca wartość true, jeżeli hasło zostało zmienione
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.passwordHash.equals(oldPassword))
            this.passwordHash = newPassword;
        else return false;
        
        return true;
    }

    /**
     * Zwraca listę celów użytkownika.
     * @return lista celów (obiektów typu BucketlistListItem)
     */
    public List<BucketlistListItem> getListItems() {
        return listItems;
    }

    /**
     * Zwraca adres email użytkownika.
     * @return adres email
     */
    public String getEmail() {
        return email;
    }

    /**
      Zwraca hasło użytkownika.
     * @return aktualne hasło użytkownika
     */
    public String getPasswordHash() {
        return passwordHash;
    }
    
    /**
     * Zwraca datę rejestracji użytkownika.
     * @return data rejestracji użytkownika
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Zwraca datę ostatniego logowania użytkownika.
     * @return data ostatniego udanego logowania
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * Ustawia nową datę ostatniego logowania.
     * @param lastLogin nowa data ostatniego udanego logowania
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Zwraca numer id obiektu reprezentującego użytkownika w bazie danych.
     * @return numer id jednoznacznie reprezentujący obiekt użytkownika
     */
    public int getId() {
        return id;
    }
    
    /**
     * Ustawia wartość identyfikatora obiektu. Metoda jest zachowana ze względu
     * na wymagania Hibernate. Nie powinna być używana.
     * @param id nowy identyfikator obiektu w bazie danych
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Ustawia nową datę rejestracji użytkownika. Metoda nie powinna być używana.
     * Jest wymagana przez Hibernate.
     * @param registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Ustawia nowy adres email użytkownika.
     * @param email nowy adres email użytkownika, maksymalnie 45 znaków
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Ustawia nowe hasło użytkownika. Metoda nie powinna być używana. Jest
     * wymagana przez Hibernate.
     * @param passwordHash nowe hasło użytkownika, maksymalnie 45 znaków
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Ustawia nową listę celów użytkownika. Metoda nie powina być uzywana. Jest
     * wymagana przez Hibernate.
     * @param listItems nowa lista celów
     */
    public void setListItems(List<BucketlistListItem> listItems) {
        this.listItems = listItems;
    }

    /**
     * Zwraca imię użytkownika.
     * @return imię użytkownika
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Ustawia imię użytkownika.
     * @param firstName nowe imię użytkownika, maksymalnie 45 znaków
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Zwraca nazwisko użytkownika.
     * @return nazwisko użytkownika
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Ustawia nazwisko użytkownika.
     * @param lastName nowe nazwisko użytkownika, maksymalnie 45 znaków
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
