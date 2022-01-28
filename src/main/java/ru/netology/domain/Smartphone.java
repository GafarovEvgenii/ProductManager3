package ru.netology.domain;

public class Smartphone extends Product {
    private String brand;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, int price, String brand) {
        super(id, price);
        this.brand = brand;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
