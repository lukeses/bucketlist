/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.BucketlistController;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Daniel
 */

@ManagedBean
@ViewScoped
public class HomepageController implements Serializable{
    
    @ManagedProperty (value = "#{databaseDAO}") 
    private BucketlistController database;

    /**
     * @param database the database to set
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }
    
    
    public List<BucketlistListItem> getList() {
        this.database.openSession();
        List<BucketlistListItem> result = this.database.getAllItems();
        this.database.closeSession();
        return result;
    }
    
}
