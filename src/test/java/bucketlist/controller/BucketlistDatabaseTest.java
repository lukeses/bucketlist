/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistItemImage;
import bucketlist.model.BucketlistUserInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanka
 */
public class BucketlistDatabaseTest implements IBucketlistDatabase {
    List<BucketlistListItem> list;
    
    public BucketlistDatabaseTest() {
        list = new ArrayList<BucketlistListItem>();
    }
    
    @Override
    public void openSession() {
    }

    @Override
    public void closeSession() {
    }

    @Override
    public List<BucketlistListItem> getAllItems() {
        return this.list;
    }

    @Override
    public void saveItem(int itemId, String name, String description) {
    }

    @Override
    public BucketlistListItem getItemById(int itemId) {
        BucketlistListItem item = new BucketlistListItem("name", "description");
        item.setItemId(itemId);
        
        return item;
    }

    @Override
    public int addMyListItem(String name, String description) {
        return 0;
    }

    @Override
    public int checkPassword(String userName, String userPassword) {
        return 1;
    }

    @Override
    public void addNewUser(String firstName, String lastName, String email1, String password1) {
    }

    @Override
    public boolean userExists(String email1) {
        return true;
    }

    @Override
    public List<BucketlistUserInfo> getAllUsersButMe() {
        return new ArrayList<BucketlistUserInfo>();
    }

    @Override
    public List<BucketlistListItem> getUserItems(int userId) {
        return null;
    }

    @Override
    public List<BucketlistUserInfo> getUserByEmail(String userName) {
        return new ArrayList<BucketlistUserInfo>();
    }

    @Override
    public void updateItem(BucketlistListItem item) {
    }

    @Override
    public void deleteItem(BucketlistListItem item) {
    }

    @Override
    public void decreaseProgress(int itemId) {
    }

    @Override
    public void increaseProgress(int itemId) {
    }

    @Override
    public void addImage(int itemId, String imgName) {
    }

    @Override
    public List<BucketlistItemImage> getItemImages(int itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BucketlistUserInfo getUser(int id) {
        return new BucketlistUserInfo("email@email.com", "password");
    }

    @Override
    public void changePassword(int userId, String newPassword) {
    }

    @Override
    public List<BucketlistUserInfo> getAllUsers() {
        return new ArrayList<BucketlistUserInfo>();
    }

    @Override
    public void deleteUser(int id) {
    }

    @Override
    public void progress100(int itemId) {
    }
    
}
