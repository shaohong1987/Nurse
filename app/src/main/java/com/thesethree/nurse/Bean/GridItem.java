package com.thesethree.nurse.Bean;

/**
 * Created by Eric on 2017-4-17.
 */

public class GridItem {
    private int index;
    private String imageUrl;

    public GridItem(int index, String imageUrl) {
        this.index = index;
        this.imageUrl = imageUrl;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
