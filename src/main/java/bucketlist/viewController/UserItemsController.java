/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.BucketlistController;
import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Daniel
 */
@ViewScoped
@Named
public class UserItemsController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private BucketlistController database;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    /**
     * @param database the database to set
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }

    private List<BucketlistListItem> list;

    public List<BucketlistListItem> getList() {
        if (list == null) {
            this.database.openSession();
            List<BucketlistUserInfo> user = database.getUserByEmail(login.getUserName());
            list = this.database.getUserItems(user.get(0).getId());
            this.database.CloseSession();
        }
        return list;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(LoginController login) {
        this.login = login;
    }

    public String editAction(BucketlistListItem item) {
        item.setEditable(true);
        return null;
    }

    public String saveAction(BucketlistListItem item) {

        item.setEditable(false);
        return null;
    }

    public String deleteAction(BucketlistListItem item) {

        return null;
    }

}
