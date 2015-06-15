/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistItemImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca cel (pojedynczy element listy) użytkownika. Obiekt celu
 * jest powiązany z obiektem użytkownika relacją kompozycji.
 *
 * @author Daniel
 */
public class BucketlistListItem {

    /**
     * Kontruktor klasy pobierający tworzący nowy obiekt z zainicjalizowanym
     * polem opisującym cel użytkownika.
     *
     * @param content opis celu użytkownika
     * @param description opis celu
     */
    public BucketlistListItem(String content, String description) {
        this.content = content;
        this.description = description;
        this.progress = 0;
        this.images = new ArrayList<>();
    }

    /**
     * Domyślny konstruktor klasy wymagany przez Hibernate. Tworzony pusty
     * obiekt celu, który wymaga zainicjalizowania opisu celu poprzez setter.
     */
    public BucketlistListItem() {
        this.images = new ArrayList<>();
    }

    private int itemId;
    private String content;
    private String description;
    private int progress;
    private List<BucketlistItemImage> images;

    /**
     * Zwraca identyfikator obiektu celu w bazie danych. Każdy cel można
     * jednoznacznie zidentyfikować za pomocą tego numeru
     *
     * @return identyfikator obiektu w bazie danych
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Ustawia wartość identyfikatora obiektu. Metoda jest zachowana ze względu
     * na wymagania Hibernate. Nie powinna być używana.
     *
     * @param itemId nowy identyfikator obiektu w bazie danych
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Zwraca opis celu zdefiniowany przy dodawaniu do bazy danych
     *
     * @return opis obiektu
     */
    public String getContent() {
        return content;
    }

    /**
     * Ustawia opis projektu. Metoda powinna być wywoływana w przypadku użycia
     * domyślnego kontruktora lub w celu edycji opisu.
     *
     * @param content nowy opis celu, nie może być dłuższy niż 200 znaków
     */
    public void setContent(String content) {
        this.content = content;
    }

    private boolean editable;

    /**
     * Sprawdza czy podany cel jest w trybie edycji
     * @return tryb edycji
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Ustawia tryb edycji dla danego celu
     * @param editable czy ma być edytowalny
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Zwraca opis celu
     * @return opis celu
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Ustawia opis celu
     * @param description opis celu
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Zwraca poziom postępu
     * @return postęp
     */
    public int getProgress() {
        return progress;
    }
    
    /**
     * Ustawia poziom postępu
     * @param progress postęp
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }
    
    /**
     * Zwraca listę zdjęć powiązanych z wybranym celem.
     * @return lista zdjęć
     */
    public List<BucketlistItemImage> getImages() {
        return images;
    }
    
    /**
     * Ustawia listę zdjęć powiązanych z wybranym celem.
     * @param images lista zdjęć
     */
    public void setImages(List<BucketlistItemImage> images) {
        this.images = images;
    }
    
    /**
     * Dodaje zdjęcie do listy zdjęć powiązanych z wybranym celem.
     * @param image zdjęcie
     */
    public void addImage(BucketlistItemImage image) {
        this.images.add(image);
    }
}
