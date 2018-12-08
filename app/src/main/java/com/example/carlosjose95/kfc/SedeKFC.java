package com.example.carlosjose95.kfc;

public class SedeKFC {
    private int image;
    private int number;
    private String name;

    public SedeKFC(int image, int number, String name) {
        this.image = image;
        this.name = name;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
