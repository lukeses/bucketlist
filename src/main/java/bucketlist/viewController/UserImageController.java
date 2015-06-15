/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistUserInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.poi.util.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * Klasa odpowiedzialna za obsługę dodawania zdjęcia profilowego.
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class UserImageController implements Serializable {

    @ManagedProperty(value = "#{databaseDAO}")
    private IBucketlistDatabase database;

    private BucketlistUserInfo user;
    private Part image;

    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     *
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }

    /**
     * Zwaraca aktualne (lub domyślne) zdjęcie profilowe użytkoniwka.
     * @return aktualne zdjęcie
     */
    public Part getImage() {
        return image;
    }

    /**
     * Ustawia nowe zdjęcię profilowe
     * @param image nowe zdjęcie użytkownika
     */
    public void setImage(Part image) {
        this.image = image;
    }
    
    /**
     * Metoda odpowiedzialna za wgywanie nowego zdjęcia użytkownika na serwer.
     * Metoda zmienia nazwę pliku na odpowiadającą aktualnemu identyfikatorowi użytkownika
     * @param e parametr przechowujący dane o wczytanym pliku
     * @return przekierowanie do strony panelu
     * @throws IOException w przypadku niepowodzenia w odczytywaniu nowego pliku
     * @throws NamingException w przypadku błędnych nazwe ścieżek lub plików
     */
    public String uploadImage(FileUploadEvent e) throws IOException, NamingException {
        if(e.getFile() != null) {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String absolutePath = ctx.getRealPath("/");
        
        absolutePath = new File(absolutePath).getParentFile().getParentFile().getPath();
        absolutePath += "/src/main/webapp/resources/userImages";
        File dir = new File(absolutePath);
	if (!dir.exists()) {
            dir.mkdir();
	}
        String imgName = user.getId() + ".jpg";
        File file = new File(absolutePath + "/" + imgName);
        
        if (!file.exists()) {
            file.createNewFile();
	}
        else {
            file.delete();
        }
        InputStream inputStream = e.getFile().getInputstream();          
        FileOutputStream outputStream = new FileOutputStream(file);
        
        byte[] buffer = new byte[4096];          
        int bytesRead = 0;  
        while(true) {                          
            bytesRead = inputStream.read(buffer);  
            if(bytesRead > 0) {  
                outputStream.write(buffer, 0, bytesRead);  
            }else {  
                break;  
            }                         
        }

        outputStream.close();  
        inputStream.close();  
        }
         
        return "/secured/userPanel.xhtml?faces-redirect=true";
    }

    /**
     * Inicjalizuje klasę obsługującą dodawania zdjęcia profilowego, pobierając dane użytkownika aktualnej sesji.
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
