package com.serafynurh.myhealth;

/**
 * Created by nyawira on 5/9/17.
 */

public class Item {
    String title;
    int image;
    int pos;

    public Item(String title, int imgae,int pos) {
        this.title = title;
        this.image = imgae;
        this.pos=pos;
    }

    public int getPos() {
        return pos;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
