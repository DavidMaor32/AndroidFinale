package com.example.androidfinale.Domain;

import java.io.Serializable;

public class PropertyDomain implements Serializable {
    private String title;
    private String type;
    private String address;
    private String description;
    private String picPath;
    private int price;
    private int bed;
    private int bath;
    private int size;
    private boolean hasGarage;
    private double score;

    public PropertyDomain(String type, String title,  String address, String description, String picPath, int price, int bed, int bath, int size, boolean hasGarage, double score) {
        this.title = title;
        this.type = type;
        this.address = address;
        this.description = description;
        this.picPath = picPath;
        this.price = price;
        this.bed = bed;
        this.bath = bath;
        this.size = size;
        this.hasGarage = hasGarage;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
