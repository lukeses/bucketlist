/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistListItem;
import bucketlist.model.BucketlistUserInfo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Daniel
 */
public class BucketlistUserInfoController {

    private final Session session;

    private static final SessionFactory factory = init();

    private static SessionFactory init() {
        Configuration configuration = new Configuration().configure();
        //new SchemaExport(configuration).create(true, false);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());

        SessionFactory fact = configuration.buildSessionFactory(builder.build());
        return fact;
    }

    public BucketlistUserInfoController() {
        session = factory.openSession();
    }

    public void CloseSession() {
        session.close();
    }

    public void addUserIntoToDB(String email, String passwordHash) {
        this.addUserInfoToDB("John", "Doe", email, passwordHash);
    }

    public void addUserInfoToDB(String firstName, String lastName, String email, String passwordHash) {
        Transaction t = session.beginTransaction();

        BucketlistUserInfo newUser = new BucketlistUserInfo();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPasswordHash(passwordHash);

        session.persist(newUser);
        t.commit();
    }

    public BucketlistUserInfo getUserInfoFromDB(int id) {
        BucketlistUserInfo retrievedUser;
        Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.id = '" + id + "'");

        retrievedUser = (BucketlistUserInfo) q.list().get(0);

        return retrievedUser;
    }

    public List<BucketlistListItem> getUserItemsFromDB(int id) {
        List<BucketlistListItem> retrievedItems;
        Query q = session.createQuery("from BucketlistListItem where itemOwner = '" + id + "'");

        retrievedItems = (List<BucketlistListItem>) q.list();

        return retrievedItems;
    }

    public List<BucketlistUserInfo> getUserInfoFromByEmailDB(String email) {

        if (email == null) {
            email = new String();
        }

        List<BucketlistUserInfo> retrievedUser;

        Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.email = '" + email + "'");

        retrievedUser = (List<BucketlistUserInfo>) q.list();

        return retrievedUser;
    }

    public void addUserAndItemListToDB(String content) {
        Transaction t = session.beginTransaction();

        BucketlistListItem newItem = new BucketlistListItem();
        newItem.setContent(content);
        BucketlistListItem newItem2 = new BucketlistListItem();
        newItem.setContent(content + "2");

        ArrayList<BucketlistListItem> items = new ArrayList<BucketlistListItem>();
        items.add(newItem);
        items.add(newItem2);

        BucketlistUserInfo newUser = new BucketlistUserInfo();
        newUser.setFirstName("Kazimierz");
        newUser.setLastName("Wielki");
        newUser.setEmail("kazimierz50@poczet.pl");
        newUser.setPasswordHash("lokietek");
        newUser.setListItems(items);

        session.persist(newUser);
        t.commit();
    }

}
