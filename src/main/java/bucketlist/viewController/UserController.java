/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author hanka
 */
@ManagedBean
@RequestScoped
public class UserController implements Serializable{
    
    @ManagedProperty (value = "#{databaseDAO}") 
    private BucketlistController database;
    private List<BucketlistUserInfo> users;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }
    
    /**
     *
     * @return
     */
    public List<BucketlistUserInfo> getUsers() {
        this.users = database.getAllUsersButMe();
        
        return this.users;
    }
    
    /**
     *
     * @return
     */
    public List<BucketlistListItem> getUserItems() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                   getExternalContext().getRequestParameterMap();
        int userId = Integer.parseInt(params.get("id"));
        database.openSession();
        List<BucketlistListItem> items = database.getUserItems(userId);
        database.closeSession();
        
        return items;
    }
    
}