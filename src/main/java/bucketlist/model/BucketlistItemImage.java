/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

import javax.faces.bean.RequestScoped;

@RequestScoped
public class BucketlistItemImage {
    private int id;
    private int itemId;
    private String imageName;

    public BucketlistItemImage(int id, int itemId, String imageName) {
        this.id = id;
        this.itemId = itemId;
        this.imageName = imageName;
    }
    
    public BucketlistItemImage(int itemId, String imageName) {
        this.itemId = itemId;
        this.imageName = imageName;
    }

    public BucketlistItemImage() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getItemId() {
        return itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    public String getImageName() {
        return imageName;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}