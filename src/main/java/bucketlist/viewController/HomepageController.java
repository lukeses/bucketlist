/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 * Klasa obsługująca stronę homepage.xhtml
 * @author Daniel
 */

@ManagedBean
@ViewScoped
public class HomepageController implements Serializable{
    
    @ManagedProperty (value = "#{databaseDAO}") 
    private IBucketlistDatabase database;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }
    
    /**
     * Zwraca listę celów dla wszystkich użytkowników.
     * @return lista celów
     */
    public List<BucketlistListItem> getList() {
        this.database.openSession();
        List<BucketlistListItem> result = this.database.getAllItems();
        this.database.closeSession();
        return result;
    }
    
}
