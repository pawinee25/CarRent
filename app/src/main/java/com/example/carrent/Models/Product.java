package com.example.carrent.Models;

public class Product {
    private String CarID;
    private String Engine;
    private double Price;
    private String Color;
    private String Images;
    private int Number;
    private String Register;
    private String BrandID;
    private String Name;

    public Product() {
    }

    public Product(String carID, String engine, double price, String color, String images, int number, String register, String brandID, String name) {
        CarID = carID;
        Engine = engine;
        Price = price;
        Color = color;
        Images = images;
        Number = number;
        Register = register;
        BrandID = brandID;
        Name = name;
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String carID) {
        CarID = carID;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getRegister() {
        return Register;
    }

    public void setRegister(String register) {
        Register = register;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
