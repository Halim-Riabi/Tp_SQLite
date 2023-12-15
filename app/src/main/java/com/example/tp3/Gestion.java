package com.example.tp3;

public class Gestion {
    private String methode;
    private int image;

    public Gestion(String methode,int image) {
        this.methode = methode;
        this.image=image;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
