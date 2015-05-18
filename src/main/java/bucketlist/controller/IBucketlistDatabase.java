/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistUserInfo;
import java.util.List;

/**
 *
 * @author hanka
 */
public interface IBucketlistDatabase {

    public void openSession();

    public void closeSession();

    public List<BucketlistListItem> getAllItems();

    public void saveItem(int itemId, String name, String description);

    public BucketlistListItem getItemById(int itemId);

    public void addMyListItem(String name, String description);

    public int checkPassword(String userName, String userPassword);

    public void addNewUser(String firstName, String lastName, String email1, String password1);

    public boolean userExists(String email1);

    public List<BucketlistUserInfo> getAllUsersButMe();

    public List<BucketlistListItem> getUserItems(int userId);

    public List<BucketlistUserInfo> getUserByEmail(String userName);

    public void updateItem(BucketlistListItem item);

    public void deleteItem(BucketlistListItem item);
    
}
