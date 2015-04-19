/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

/**
 *
 * @author Daniel
 */
public class BucketlistListItem {
    public BucketlistListItem(String content) {
        this.content = content;
    }
    
    private int itemId;
    private String content;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
