package com.example.hobo.mycontacts.pojo;

/**
 * Created by Caleb on 7/4/2017.
 */

public class Contact {

    private String id;
    private String urlPhoto;
    private String fullName;
    private int likes;

    public Contact() {
    }

    public Contact(String urlPhoto, String fullName, int likes) {
        this.urlPhoto = urlPhoto;
        this.fullName = fullName;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
