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
public class BucketlistController {

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

    public BucketlistController() {
        session = factory.openSession();
    }

    public void CloseSession() {
        session.close();
    }

    public void addNewUser(String email, String passwordHash) {
        this.addNewUser(null, null, email, passwordHash);
    }
    
    public void addNewUser(String firstName, String lastName, String email, String passwordHash) {
        Transaction t = session.beginTransaction();

        BucketlistUserInfo newUser = new BucketlistUserInfo(firstName, lastName, email, passwordHash);

        session.persist(newUser);
        t.commit();
    }
    
    public BucketlistUserInfo getUser(int id) {
        BucketlistUserInfo retrievedUser;
        //Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.id = '" + id + "'");
        
        retrievedUser = (BucketlistUserInfo)session.get(BucketlistUserInfo.class, id); //q.list().get(0);
        
        return retrievedUser;
    }
    
    public void addListItemToUser(int userId, String content)
    {
        Transaction t = session.beginTransaction();

        BucketlistListItem newItem = new BucketlistListItem(content);
        
        BucketlistUserInfo user = getUser(userId);
        user.getListItems().add(newItem);

        session.persist(user);
        t.commit();
    }

    public List<BucketlistListItem> getUserItems(int id) {
        List<BucketlistListItem> retrievedItems;
        Query q = session.createQuery("from BucketlistListItem where itemOwner = '" + id + "'");

        retrievedItems = (List<BucketlistListItem>) q.list();

        return retrievedItems;
    }

    public BucketlistUserInfo getUserByEmail(String email) {

        if (email == null) {
            email = new String();
        }

        BucketlistUserInfo retrievedUser;

        Query q = session.createQuery("from BucketlistUserInfo as userInfo where userInfo.email = '" + email + "'");

        retrievedUser = (BucketlistUserInfo) q.list().get(0);

        return retrievedUser;
    }
}