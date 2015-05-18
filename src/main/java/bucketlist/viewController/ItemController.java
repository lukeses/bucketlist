/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Klasa obsługująca żądania ze strony addItem.xhtml.
 * Umożliwia dodanie nowego celu do listy celów użytkownika
 * @author hanka
 */
@ManagedBean
@RequestScoped
public class ItemController {
    @ManagedProperty (value = "#{databaseDAO}") 
    private BucketlistController database;
    
    private int itemId;
    private String name;
    private String description;
    
    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }
    
    /**
     * Pobiera identyfikator celu
     * @return zwraca identyfikator celu
     */
    public int getItemId() {
        return this.itemId;
    }
    
    /**
     * Ustawia identyfikator celu
     * @param itemId identyfikator celu
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    /**
     * Pobiera nazwę celu
     * @return zwraca nazwę celu
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Ustawia nazwę celu
     * @param name nazwa celu
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Pobiera opis celu
     * @return zwraca opis celu
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Ustawia opis celu
     * @param description opis celu
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Dodaje cel do listy celów użytkownika i przekierowuje do listy celów użytkownika
     * @return docelowy adres url
     */
    public String addItem() {
        database.addMyListItem(this.name, this.description);
        
        return "/secured/userItems.xhtml?faces-redirect=true";
    }

    /**
     * Edytuje cel użytkownika i przekierowuje do listy celów użytkownika
     * @return docelowy adres url
     */
    public String update() {
        database.saveItem(this.itemId, this.name, this.description);
        
        return "/secured/userItems.xhtml?faces-redirect=true";
    }
    
    /**
     * Inicjalizuje pola formularza umożliwiającego dodanie celu w przypadku przejęcia celu wybranego użytkownika
     */
    public void init() {
        if(itemId != 0) {
            database.openSession();
            BucketlistListItem item = database.getItemById(this.itemId);


            this.name = item.getContent();
            this.description = item.getDescription();
        }
        else {
            this.name = "";
            this.description = "";
        }
    }
}
