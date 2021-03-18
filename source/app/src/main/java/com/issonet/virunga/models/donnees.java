package com.issonet.virunga.models;

public class donnees {
    private  int id;
    private String title,description;
    private int image_url;

    public donnees(int id, String title, String description, int image_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage_url() {
        return image_url;
    }
}
