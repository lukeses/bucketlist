/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistItemImage;
import bucketlist.model.BucketlistUserInfo;
import java.util.List;

/**
 * Interfejs kontrolera dostępu do bazy danych
 * @author hanka
 */
public interface IBucketlistDatabase {

    /**
     * Przy wywołaniu otwiera nową sesję umożliwiającą komunikację z bazą
     * danych.
     */
    public void openSession();

    /**
     * Metoda powinna być wywoływana po zakończeniu pracy z kontrolerem w celu
     * zamknięcia sesji i umożliwienia zwolnienia nieużywanych zasobów.
     */
    public void closeSession();

    /**
     * Metoda zwraca wszystkie cele
     *
     * @return cele
     */
    public List<BucketlistListItem> getAllItems();

    /**
     * Zapisuje cel
     *
     * @param itemId id celu
     * @param name zawartość celu
     * @param description opis celu
     */
    public void saveItem(int itemId, String name, String description);

    /**
     * Zwraca cel o podanym id
     *
     * @param itemId id celu
     * @return cel
     */
    public BucketlistListItem getItemById(int itemId);

    /**
     * Dodaje cel dla zalogowanego użytkownika
     *
     * @param name zawartość
     * @param description opis
     * @return id dodanego celu
     */
    public int addMyListItem(String name, String description);

    /**
     * Metoda sprawdzająca poprawność hasła dla danego adresu email.
     *
     * @param userName email użytkownika
     * @param userPassword hasło
     * @return id w przypadku powodzenia, -1 w przeciwnym razie
     */
    public int checkPassword(String userName, String userPassword);

    /**
     * Metoda służy do dodawania do bazy danych nowego użytkownika ze
     * zdefiniowanym imieniem, nazwiskiem, adresem email i hasłem. Jest to
     * kompletny zestaw informacji przechowywanych na temat użytkownika.
     *
     * @param firstName imię nowego użytkownika
     * @param lastName nazwisko nowego użytkonwika
     * @param email1 adres email, który ma być przypisany do nowego użytkwnika
     * @param password1 hasło nowego użytkownika
     */
    public void addNewUser(String firstName, String lastName, String email1, String password1);

    /**
     * Sprawdza czy użytkownik o podanym adresie email istnieje
     *
     * @param email1 adres email
     * @return czy istnieje
     */
    public boolean userExists(String email1);

    /**
     * Zwraca listę wszystkich użytkowników poza zalogowanym
     *
     * @return lista użytkowników
     */
    public List<BucketlistUserInfo> getAllUsersButMe();
    
    /**
     * Zwraca listę wszystkich użytkowników
     *
     * @return lista użytkowników
     */
    public List<BucketlistUserInfo> getAllUsers();

    /**
     * Metoda zwraca cele danego użytkownika
     *
     * @param userId
     * @return cele użytkownika
     */
    public List<BucketlistListItem> getUserItems(int userId);

    /**
     * Metoda zwraca użytkownika
     *
     * @param userName Email użytkownika, który ma być zwrócony
     * @return obiekt przechowujący dostępne dane o użytkowniku
     */
    public List<BucketlistUserInfo> getUserByEmail(String userName);

    /**
     * Aktualizuje zawartość podanego celu
     *
     * @param item cel
     */
    public void updateItem(BucketlistListItem item);

    /**
     * Usuwa podany cel
     *
     * @param item cel
     */
    public void deleteItem(BucketlistListItem item);
    
    public void decreaseProgress(int itemId);
    
    public void increaseProgress(int itemId);

    public void addImage(int itemId, String imgName);

    public List<BucketlistItemImage> getItemImages(int itemId);
    
    /**
     * Zwraca użytkownika o podanym id
     *
     * @param id identyfikator użytkownika
     * @return użytkownik o podanym identyfikatorze
     */
    public BucketlistUserInfo getUser(int id);
    
    /**
     * Zmienia hasło użytkownika o podanym id
     *
     * @param userId identyfikator użytkownika
     * @param newPassword nowe hasło użytkownika
     */
    public void changePassword(int userId, String newPassword);
    
    /**
     * Usuwa użytkownika o podanym id
     *
     * @param id identyfikator użytkownika
     */
    public void deleteUser(int id);

    public void progress100(int itemId);
}
