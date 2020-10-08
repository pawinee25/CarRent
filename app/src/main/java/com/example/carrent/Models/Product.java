package com.example.carrent.Models;

public class Product {
    private String engine;
    private String type;
    private String gear;
    private String door;
    private Double price;
    private String color;
    private String images;
    private String numberseats;
    private String register;
    private String brandname;
    private String modelname;

    public Product(String engine, String type, String gear, String door, Double price, String color, String images, String numberseats, String register, String brandname, String modelname) {
        this.engine = engine;
        this.type = type;
        this.gear = gear;
        this.door = door;
        this.price = price;
        this.color = color;
        this.images = images;
        this.numberseats = numberseats;
        this.register = register;
        this.brandname = brandname;
        this.modelname = modelname;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getNumberseats() {
        return numberseats;
    }

    public void setNumberseats(String numberseats) {
        this.numberseats = numberseats;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }
}
