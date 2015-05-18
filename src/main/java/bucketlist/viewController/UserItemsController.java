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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean
@ViewScoped
public class UserItemsController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private BucketlistController database;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(BucketlistController database) {
        this.database = database;
    }

    private List<BucketlistListItem> list;

    /**
     *
     * @return
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
     * @param login the login to set
     */
    public void setLogin(LoginController login) {
        this.login = login;
    }

    /**
     *
     * @param item
     * @return
     */
    public String editAction(BucketlistListItem item) {
        item.setEditable(true);
        return null;
    }

    /**
     *
     * @param item
     * @return
     */
    public String saveAction(BucketlistListItem item) {
        database.openSession();
        database.updateItem(item);
        database.closeSession();
        item.setEditable(false);
        return null;
    }

    /**
     *
     * @param item
     * @return
     */
    public String deleteAction(BucketlistListItem item) {
        database.openSession();
        database.deleteItem(item);
        database.closeSession();
        list = null;
        return null;
    }

}
