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
            /*for(BucketlistListItem item : list) {
                List<BucketlistItemImage> imgList = this.database.getItemImages(item.getItemId());
                
                item.setImages(imgList);
                if(imgList != null)
                    item.setMainImg(imgList.get(0).getImageName());
                else
                    item.setMainImg("");
            }*/
            this.database.closeSession();
        }
        
            /*List<BucketlistItemImage> images = new ArrayList<>();
            images.add(new BucketlistItemImage(1, "tiger.jpg"));
            images.add(new BucketlistItemImage(2, "sheep.jpg"));
            for(BucketlistListItem item : list) {
                item.setImages(images);
            }*/
        
        return list;
    }
    
    public List<String> getImageNames(int itemId) {
        List<BucketlistItemImage> images;
        this.database.openSession();
        images = this.database.getItemImages(itemId);
        this.database.closeSession();

        List<String> names = new ArrayList<>();
        for(BucketlistItemImage i : images) {
            names.add(i.getImageName());
        }
        
        return names;
    }
    
    /*public String getMainImage(int itemId) throws NamingException {
        if (images == null) {
            this.database.openSession();
            images = this.database.getItemImages(itemId);
            this.database.closeSession();
        }
        
        if(images.size() > 0)
            return images.get(0).getImageName();
        else
            return "";
    }*/

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
    
    public void decreaseProgress(int itemId) {
        database.openSession();
        database.decreaseProgress(itemId);
        database.closeSession();
    }
    
    public void increaseProgress(int itemId) {
        database.openSession();
        database.increaseProgress(itemId);
        database.closeSession();
    }
}
