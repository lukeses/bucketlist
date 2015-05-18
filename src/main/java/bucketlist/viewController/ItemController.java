/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.model.BucketlistListItem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
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
    
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }
    
    public int getItemId() {
        return this.itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String addItem() {
        database.addListItemToUser(getMyId(), this.name, this.description);
        
        return "/secured/userItems.xhtml?faces-redirect=true";
    }

    public String update() {
        database.saveItem(this.itemId, this.name, this.description);
        
        return "/secured/userItems.xhtml?faces-redirect=true";
    }
    
    public void init() {
        database.openSession();
        BucketlistListItem item = database.getItemById(this.itemId);

        this.name = item.getContent();
        this.description = item.getDescription();
    }
    
    public int getMyId() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        
        if(session.getAttribute("userId") == null)
            return -1;
        else 
            return (int) session.getAttribute("userId");
    }
}
