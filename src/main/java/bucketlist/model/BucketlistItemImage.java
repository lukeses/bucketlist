/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

import javax.faces.bean.RequestScoped;

/**
 * Klasa reprezentująca zdjęcie powiązane z celem.
 */
@RequestScoped
public class BucketlistItemImage {
    private int id;
    private int itemId;
    private String imageName;

    /**
     * Kompletny kontruktor klasy.
     * @param id identyfikator rekordu w bazie danych
     * @param itemId identyfikator celu
     * @param imageName nazwa zdjecia
     */
    public BucketlistItemImage(int id, int itemId, String imageName) {
        this.id = id;
        this.itemId = itemId;
        this.imageName = imageName;
    }
    
    /**
     * Konstruktor przyjmujący jako parametry minimalny zestaw informacji
     * umożliwiających powiązanie zdjęcia z wybranym celem.
     * @param itemId identyfikator celu
     * @param imageName nazwa zdjecia
     */
    public BucketlistItemImage(int itemId, String imageName) {
        this.itemId = itemId;
        this.imageName = imageName;
    }
    
    /**
     * Domyślny kontruktor. Nie powinien być używany, jest wymagany przez
     * Hibernate. 
     */
    public BucketlistItemImage() {
    }
    
    /**
     * Zwraca identyfikator rekordu
     * @return identyfikator rekordu
     */
    public int getId() {
        return id;
    }
    
    /**
     * Ustawia wartość identyfikatora rekordu.
     * @param id nowy identyfikator rekordu w bazie danych
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Zwraca identyfikator celu.
     * @return identyfikator celu
     */
    public int getItemId() {
        return itemId;
    }
    
    /**
     * Ustawia wartość identyfikatora celu.
     * @param itemId identyfikator celu powiązanego z wybranym zdjęciem
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    /**
     * Zwraca nazwę zdjęcia.
     * @return nazwa zdjęcia
     */
    public String getImageName() {
        return imageName;
    }
    
    /**
     * Ustawia nazwę zdjęcia.
     * @param imageName nazwa zdjęcia powiązanego z wybranym celem
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}