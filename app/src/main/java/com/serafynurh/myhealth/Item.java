package com.serafynurh.myhealth;

/**
 * Created by nyawira on 5/9/17.
 */

public class Item {
    String title;
    int image;

    public Item(String title, int imgae) {
        this.title = title;
        this.image = imgae;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
