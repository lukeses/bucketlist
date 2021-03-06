/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Klasa obsługująca żądania ze strony users.xhtml.
 * Wyświetla użytkowników zarejestrowanych w systemie z wyłączeniem obecnie zalogowanego użytkownika.
 * @author hanka
 */
@ManagedBean
@RequestScoped
public class UserController implements Serializable{
    
    @ManagedProperty (value = "#{databaseDAO}") 
    private IBucketlistDatabase database;
    private List<BucketlistUserInfo> users;
    private int userId;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }
    
    /**
     * Ustawia id użytkownika
     * @param userId id użytkownika
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /**
     * Zwraca id użytkownika
     * @return id użytkownika
     */
    public int getUserId() {
        return this.userId;
    }
    
    /**
     * Metoda pobiera listę użytkowników zarejestrowanych w systemie
     * @return zwraca listę użytkowników zarejestrowanych w systemie
     */
    public List<BucketlistUserInfo> getUsers() {
        this.database.openSession();
        this.users = database.getAllUsers();
        this.database.closeSession();
        
        return this.users;
    }
    
    /**
     * Metoda pobiera listę celów powiązanych z użytkownikiem
     * @return zwraca listę celów powiązanych z użytkownikiem
     */
    public List<BucketlistListItem> getUserItems() {
        Map<String, String> params;
        if(FacesContext.getCurrentInstance() != null) {
            params = FacesContext.getCurrentInstance().
                   getExternalContext().getRequestParameterMap();
            this.userId = Integer.parseInt(params.get("id"));
        }
        else
            this.userId = -1;
        
        database.openSession();
        List<BucketlistListItem> items = database.getUserItems(this.userId);
        database.closeSession();
        
        return items;
    }
    
}