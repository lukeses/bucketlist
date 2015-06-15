/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistItemImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;

/**
 * Klasa obsługująca żądania ze strony addItem.xhtml.
 * Umożliwia dodanie nowego celu do listy celów użytkownika
 * @author hanka
 */
@ManagedBean
@RequestScoped
public class ItemController implements Serializable{
    @ManagedProperty (value = "#{databaseDAO}") 
    private IBucketlistDatabase database;
    
    private int itemId;
    private String name;
    private String description;
    private Part image;
    private Integer somebodysItemId;
    
    /**
     * Miejsce wstrzyknięcia klasy obsługującej bazę danych
     * @param database obiekt do wstrzyknięcia
     */
    public void setDatabase(IBucketlistDatabase database) {
        this.database = database;
    }
    
    /**
     * Pobiera identyfikator celu
     * @return zwraca identyfikator celu
     */
    public int getItemId() {
        return this.itemId;
    }
    
    /**
     * Ustawia identyfikator celu
     * @param itemId identyfikator celu
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    /**
     * Pobiera nazwę celu
     * @return zwraca nazwę celu
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Ustawia nazwę celu
     * @param name nazwa celu
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Pobiera opis celu
     * @return zwraca opis celu
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Ustawia zdjęcie powiązane z celem
     * @param description opis celu
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Pobiera identyfikator celu pobranego od innego użytkownika.
     * @return zwraca identyfikator celu
     */
    public Integer getSomebodysItemId() {
        return this.somebodysItemId;
    }
    
    /**
     * Ustawia identyfikator celu pobranego od innego użytkownika.
     * @param somebodysItemId identyfikator celu
     */
    public void setSomebodysItemId(Integer somebodysItemId) {
        this.somebodysItemId = somebodysItemId;
    }
    
    /**
     * Pobiera zdjęcie powiązane z celem
     * @return zwraca zdjęcie
     */
    public Part getImage() {
        return this.image;
    }
        
    /**
     * Ustawia zdjęcie powiązane z celem
     * @param image zdjęcie
     */
    public void setImage(Part image) {
        this.image = image;
    }
    
    /**
     * Dodaje cel do listy celów użytkownika i przekierowuje do listy celów użytkownika
     * @return docelowy adres url
     */
    public String addItem() {
        database.openSession();
        int id;
        id = database.addMyListItem(this.name, this.description);
        database.closeSession();
        
        if(this.somebodysItemId != null) {
            List<BucketlistItemImage> images = database.getItemImages(somebodysItemId);
            database.openSession();
            for(BucketlistItemImage i : images) {
                database.addImage(id, i.getImageName());
            }
            database.closeSession();
        }
        
        return "/secured/userItems.xhtml?faces-redirect=true";
    }

    /**
     * Edytuje cel użytkownika i przekierowuje do listy celów użytkownika
     * @return docelowy adres url
     */
    public String update() {
        database.saveItem(this.itemId, this.name, this.description);
        
        return "/secured/userItems.xhtml?faces-redirect=true";
    }
    
    /**
     * Inicjalizuje pola formularza umożliwiającego dodanie celu w przypadku przejęcia celu wybranego użytkownika
     */
    public void init() {
        if(itemId != 0) {
            database.openSession();
            BucketlistListItem item = database.getItemById(this.itemId);
            database.closeSession();

            this.name = item.getContent();
            this.description = item.getDescription();
            this.somebodysItemId = item.getItemId();
        }
        else {
            this.name = "";
            this.description = "";
            this.somebodysItemId = null;
        }
    }
    
    /**
     * Dodaje zdjęcie do wybranego celu i przekierowuje do listy celów użytkownika
     * @return docelowy adres url
     */
    public String uploadImage() throws IOException, NamingException {
        if(image != null) {
            if(validateExtension(getFilename(image)))
            {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String absolutePath = ctx.getRealPath("/");
        
        absolutePath = new File(absolutePath).getParentFile().getParentFile().getPath();
        absolutePath += "/src/main/webapp/resources/images";
        File dir = new File(absolutePath);
	if (!dir.exists()) {
            dir.mkdir();
	}
        String imgName = getFilename(image);
        File file = new File(absolutePath + "/" + imgName);
        
        InputStream inputStream = image.getInputStream();          
        FileOutputStream outputStream = new FileOutputStream(file);  
        if (!file.exists()) {
            file.createNewFile();
	}
          
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
        
        database.openSession();
        database.addImage(itemId, imgName);
        database.closeSession();

        outputStream.close();  
        inputStream.close();  
        }
        }
         
        return "/secured/userItems.xhtml?faces-redirect=true";
    }
    
    /**
     * Pobiera z nagłówka żądania nazwę dodawanego do celu zdjęcia
     * @return nazwa dodawanego zdjęcia
     */
    public static String getFilename(Part part) {  
        if(part != null) {
        for (String cd : part.getHeader("content-disposition").split(";")) {  
            if (cd.trim().startsWith("filename")) {  
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
            }  
        }  
        }
        return null;  
    } 
    
    /**
     * Wyodrębnia rozszerzenie z nazwy pliku.
     * @return rozszerzenie pliku
     */
    public static String getExtension(String filename) {  
        return FilenameUtils.getExtension(filename); 
    } 
    
    /**
     * Sprawdza czy dodawany plik jest obrazem.
     * @return true w przypadku gdy plik jest obrazem, false w przeciwnym razie
     */
    public boolean validateExtension(String filename) {  
        String extenstion = getExtension(filename);
        extenstion = extenstion.toUpperCase();
        if(extenstion.compareTo("JPG") == 0 || extenstion.compareTo("JPEG") == 0 
                || extenstion.compareTo("PNG") == 0 || extenstion.compareTo("GIF") == 0)
            return true;
        else 
            return false;
    } 
}
