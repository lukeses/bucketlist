/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class UserPanelController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private IBucketlistDatabase database;

    private BucketlistUserInfo user;
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;
    private String userImage;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     *
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getUserImage() {
        return user.getUserImage();
    }
    

    public void tryToChangePassword() {
        String resultMsg = null;
        FacesContext context = FacesContext.getCurrentInstance();
        if (user != null && newPassword1.equals(newPassword2)) {
            if (!user.changePassword(oldPassword, newPassword1)) {
                resultMsg = "Some error occured.";
            } else {
                database.openSession();
                database.changePassword(user.getId(), newPassword1);
                database.closeSession();
                resultMsg = "The operation was successfull.";
            }
        } else {
            resultMsg = "Some error occured.";
        }
        FacesMessage msg = new FacesMessage(resultMsg, "ERROR MSG");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                if (context != null) {
                    context.addMessage(null, msg);
                }
    }
    
    public void tryToDeleteUser() {
        if (user != null)
        {
            database.openSession();
            int passwordCheck = database.checkPassword(user.getEmail(), oldPassword);
            database.closeSession();
            if (passwordCheck == user.getId()) {
                database.openSession();
                database.deleteUser(passwordCheck);
                database.closeSession();
            }
        }
    }

    /**
     * Inicjalizuje pola formularza umożliwiającego dodanie celu w przypadku
     * przejęcia celu wybranego użytkownika
     */
    public void init() {
        int userId = 0;
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            userId = (int) session.getAttribute("userId");
        }
        if (userId > 0) {
            database.openSession();
            this.user = database.getUser(userId);
            database.closeSession();
        } else {
            FacesMessage msg = new FacesMessage("Some error occured.", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            if (context != null) {
                context.addMessage(null, msg);
            }
        }

    }
}
