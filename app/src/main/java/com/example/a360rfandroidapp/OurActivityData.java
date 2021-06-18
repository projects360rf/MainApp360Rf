package com.example.a360rfandroidapp;

public class OurActivityData {

    private String name;
    private String description;
    private String date;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public OurActivityData(String name, String description, String date, String image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
    }
}
