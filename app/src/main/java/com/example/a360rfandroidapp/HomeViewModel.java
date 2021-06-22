package com.example.a360rfandroidapp;


public class HomeViewModel {

    int Image;

    public HomeViewModel() {
    }

    public HomeViewModel(int image) {
        Image = image;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}