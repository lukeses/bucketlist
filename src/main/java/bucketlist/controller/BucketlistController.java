/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistUserInfo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Klasa zajmująca się komunikacją z bazą danych, zawiera metody używane przez
 * resztę kodu w aplikacji do odczytywania aktualnego stanu bazy i uaktualniania
 * jej. Interakcja aplikacji z bazą danych jest ograniczona przez publiczne
 * metody tej klasy. Klasa używa do komunikacji z bazą danych obiektu
 * reprezentującego sesję.
 *
 * @author Daniel
 */
@SessionScoped
@ManagedBean(name = "databaseDAO")
public class BucketlistController implements Serializable, IBucketlistDatabase {

    private Session session;

    private static final SessionFactory factory = init();

    private static SessionFactory init() {
        Configuration configuration = new Configuration().configure();
        //new SchemaExport(configuration).create(true, false);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());

        SessionFactory fact = configuration.buildSessionFactory(builder.build());
        return fact;
    }

    /**
     * Przy wywołaniu otwiera nową sesję umożliwiającą komunikację z bazą
     * danych.
     */
    public void openSession() {
        session = factory.openSession();
    }

    /**
     * Metoda powinna być wywoływana po zakończeniu pracy z kontrolerem w celu
     * zamknięcia sesji i umożliwienia zwolnienia nieużywanych zasobów.
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Metoda służy do dodawania do bazy danych nowego użytkownika ze
     * zdefiniowanym adresem email i hasłem. Jest to minimalny zestaw informacji
     * umożliwiający stworzenie nowego użytkownika.
     *
     * @param email adres email, który ma być przypisany do nowego użytkwnika
     * @param passwordHash hasło nowego użytkownika
     */
    public void addNewUser(String email, String passwordHash) {
        this.addNewUser(null, null, email, passwordHash);
    }

    /**
     * Metoda służy do dodawania do bazy danych nowego użytkownika ze
     * zdefiniowanym imieniem, nazwiskiem, adresem email i hasłem. Jest to
     * kompletny zestaw informacji przechowywanych na temat użytkownika.
     *
     * @param firstName imię nowego użytkownika
     * @param lastName nazwisko nowego użytkonwika
     * @param email adres email, który ma być przypisany do nowego użytkwnika
     * @param passwordHash hasło nowego użytkownika
     */
    public void addNewUser(String firstName, String lastName, String email, String passwordHash) {
        Transaction t = session.beginTransaction();

        BucketlistUserInfo newUser = new BucketlistUserInfo(firstName, lastName, email, passwordHash);

        session.persist(newUser);
        t.commit();
    }

    /**
     * Metoda zwracająca kompletny obiekt BucketlistUserInfo przechowujący
     * wszystkie informacje o użytkonwiku zdefiniowane podczas wprowadzania do
     * bazy danych.
     *
     * @param id numer id użytkownika serwisu, którego obiekt ma być zwrócony
     * @return obiekt przechowujący dostępne dane o użytkowniku
     */
    public BucketlistUserInfo getUser(int id) {
        BucketlistUserInfo retrievedUser;
        //Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.id = '" + id + "'");

        retrievedUser = (BucketlistUserInfo) session.get(BucketlistUserInfo.class, id); //q.list().get(0);

        return retrievedUser;
    }

    /**
     * Metoda dodająca użytkownikowi o podanym id nowy cel o zawartości podanej
     * w parametrze content.
     *
     * @param userId numer id użytkownika, który będzie miał dodany nowy cel
     * @param content zawartość celu, która ma być dodana użytkownikowi
     * @param description opis celu
     */
    public void addListItemToUser(int userId, String content, String description) {
        openSession();
        Transaction t = session.beginTransaction();

        BucketlistListItem newItem = new BucketlistListItem(content, description);

        BucketlistUserInfo user = getUser(userId);
        user.getListItems().add(newItem);

        session.persist(user);
        t.commit();
        closeSession();
    }

    /**
     * Metoda zwraca cele danego użytkownika
     *
     * @param id
     * @return cele użytkownika
     */
    public List<BucketlistListItem> getUserItems(int id) {
        List<BucketlistListItem> retrievedItems;
        Query q = session.createQuery("from BucketlistListItem where itemOwner = '" + id + "'");

        retrievedItems = (List<BucketlistListItem>) q.list();

        return retrievedItems;
    }

    /**
     * Metoda zwraca wszystkie cele
     *
     * @return cele
     */
    public List<BucketlistListItem> getAllItems() {
        List<BucketlistListItem> retrievedItems;
        Query q = session.createQuery("from BucketlistListItem");
        retrievedItems = (List<BucketlistListItem>) q.list();

        return retrievedItems;
    }

    /**
     * Metoda zwraca użytkownika
     *
     * @param email Email użytkownika, który ma być zwrócony
     * @return obiekt przechowujący dostępne dane o użytkowniku
     */
    public List<BucketlistUserInfo> getUserByEmail(String email) {

        if (email == null) {
            email = new String();
        }

        List<BucketlistUserInfo> retrievedUser;

        Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.email = '" + email + "'");

        retrievedUser = (List<BucketlistUserInfo>) q.list();

        return retrievedUser;
    }

    /**
     * Metoda sprawdzająca poprawność hasła dla danego adresu email.
     * @param userEmail email użytkownika
     * @param password hasło
     * @return id w przypadku powodzenia, -1 w przeciwnym razie
     */
    public int checkPassword(String userEmail, String password) {

        List<BucketlistUserInfo> retrievedUser;

        Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.email = '" + userEmail + "'");

        retrievedUser = (List<BucketlistUserInfo>) q.list();

        if (!retrievedUser.isEmpty() && retrievedUser.get(0).getPasswordHash().equals(password)) {
            return retrievedUser.get(0).getId();
        } else {
            return -1;
        }
    }

    /**
     * Zwraca cel o podanym id
     * @param itemId id celu
     * @return cel
     */
    public BucketlistListItem getItemById(int itemId) {
        List<BucketlistListItem> retrievedItems;
        Query q = session.createQuery("from BucketlistListItem where item_id = " + itemId);
        retrievedItems = (List<BucketlistListItem>) q.list();

        return retrievedItems.get(0);
    }

    /**
     * Zapisuje cel
     * @param itemId id celu
     * @param name zawartość celu
     * @param description opis celu
     */
    public void saveItem(int itemId, String name, String description) {
        Transaction t = session.beginTransaction();
        BucketlistListItem item = getItemById(itemId);
        item.setContent(name);
        item.setDescription(description);
        t.commit();
    }

    /**
     * Sprawdza czy użytkownik o podanym adresie email istnieje
     * @param userEmail adres email
     * @return czy istnieje
     */
    public boolean userExists(String userEmail) {
        List<BucketlistUserInfo> retrievedUser;

        Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.email = '" + userEmail + "'");

        retrievedUser = (List<BucketlistUserInfo>) q.list();

        return !retrievedUser.isEmpty();
    }


    /**
     * Aktualizuje zawartość podanego celu
     * @param item cel
     */
    public void updateItem(BucketlistListItem item) {
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("update BucketlistListItem set content = :content"
                + " where id = :id");
        query.setParameter("content", item.getContent());
        query.setParameter("id", item.getItemId());
        query.executeUpdate();
        t.commit();
    }
    
    /**
     * Usuwa podany cel
     * @param item cel
     */
    public void deleteItem(BucketlistListItem item) {
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM BucketlistListItem"
                + " where id = :id");
        query.setParameter("id", item.getItemId());
        query.executeUpdate();
        t.commit();
    }
    
    /**
     * Dodaje cel dla zalogowanego użytkownika
     * @param content zawartość
     * @param description opis
     */
    public void addMyListItem(String content, String description)
    {
        int myId = getMyId();
        addListItemToUser(myId, content, description);
    }
    
    /**
     * Zwraca listę wszystkich użytkowników poza zalogowanym
     * @return lista użytkowników
     */
    public List<BucketlistUserInfo> getAllUsersButMe() {
        int myId = getMyId();
        List<BucketlistUserInfo> users;
        openSession();
        Query q = session.createQuery("from BucketlistUserInfo where id <> " + myId);
        users = (List<BucketlistUserInfo>) q.list();
        closeSession();
        
        return users;
    }
    
    /**
     * Zwraca id zalogowanego użytkownika
     * @return id użytkownika
     */
    public int getMyId() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession sess = (HttpSession) context.getExternalContext().getSession(true);
        
        if(sess.getAttribute("userId") == null)
            return -1;
        else 
            return (int) sess.getAttribute("userId");
    }

}
