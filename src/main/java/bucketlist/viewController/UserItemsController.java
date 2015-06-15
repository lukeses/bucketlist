/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistItemImage;
import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Klasa obsługująca żądania ze strony userItems.xhtml.
 * Wyświetla i edytuje cele użytkownika.
 * @author AdamS
 */
@ManagedBean
@ViewScoped
public class UserItemsController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private IBucketlistDatabase database;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }

    private List<BucketlistListItem> list;

    /**
     * Zwraca listę celów zalogowanego użytkownika
     * @return lista celów
     */
    public List<BucketlistListItem> getList() {
        if (list == null) {
            this.database.openSession();
            List<BucketlistUserInfo> user = database.getUserByEmail(login.getUserName());
            list = this.database.getUserItems(user.get(0).getId());
            this.database.closeSession();
        }

        return list;
    }
    
    /**
     * Zwraca listę nazw zdjęć powiązanych z wybranym celem
     * @param itemId identyfikator celu
     * @return lista nazw zdjęć
     */
    private List<String> getImageNames(int itemId) {
        List<BucketlistItemImage> images;
        //this.database.openSession();
        images = this.database.getItemImages(itemId);
        //this.database.closeSession();

        List<String> names = new ArrayList<>();
        for(BucketlistItemImage i : images) {
            names.add(i.getImageName());
        }
        
        return names;
    }
    
    /**
     * Zwraca listę nazw zdjęć powiązanych z wybranym celem z wyłączeniem głównego zdjęcia
     * @param itemId identyfikator celu
     * @return lista nazw zdjęć
     */
    public List<String> getImageNamesWithoutFirst(int itemId) {
        List<BucketlistItemImage> images;
        //this.database.openSession();
        images = this.database.getItemImages(itemId);
        //this.database.closeSession();

        List<String> names = new ArrayList<>();
        for(BucketlistItemImage i : images) {
            names.add(i.getImageName());
        }
        
        if(names.size() > 0)
            names.remove(0);
        
        return names;
    }
    
    /**
     * Zwraca nazwę głównego zdjęcia powiązanego z wybranym celem
     * @param itemId identyfikator celu
     * @return nazwa głównego zdjęcia
     */
    public String getMainImage(int itemId) {
        List<String> images = getImageNames(itemId);
        
        if(images.size() > 0)
            return images.get(0);
        
        return "#";
    }

    /**
     * Miejsce wstrzyknięcia klasy obsługującej stan sesji użytkownika
     * @param login obiekt do wstrzyknięcia
     */
    public void setLogin(LoginController login) {
        this.login = login;
    }

    /**
     * Pozwala na edycję celu
     * @param item cel do edytowania
     * @return null
     */
    public String editAction(BucketlistListItem item) {
        item.setEditable(true);
        return null;
    }

    /**
     * Pozwala zapisać zmiany w danym celu
     * @param item cel do zapisu
     * @return null
     */
    public String saveAction(BucketlistListItem item) {
        database.openSession();
        database.updateItem(item);
        database.closeSession(); 
        item.setEditable(false);
        return null;
    }

    /**
     * Pozwala usunąć dany cel
     * @param item cel do usunięcia
     * @return null
     */
    public String deleteAction(BucketlistListItem item) {
        database.openSession();
        database.deleteItem(item);
        database.closeSession();
        list = null;
        return null;
    }
    
    /**
     * Zmniejsza poziom realizacji wybranego celu o 10%.
     * @param itemId identyfikator celu
     */
    public void decreaseProgress(int itemId) {
        database.openSession();
        database.decreaseProgress(itemId);
        database.closeSession();
    }
    
    /**
     * Zwiększa poziom realizacji wybranego celu o 10%.
     * @param itemId identyfikator celu
     */
    public void increaseProgress(int itemId) {
        database.openSession();
        database.increaseProgress(itemId);
        database.closeSession();
    }
    
    /**
     * Zwiększa poziom realizacji wybranego celu do 100%.
     * @param itemId identyfikator celu
     */
    public void progress100(int itemId) {
        database.openSession();
        database.progress100(itemId);
        database.closeSession();
    }

}
