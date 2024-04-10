package com.beverage.pricing.entity;

public class Customer {
    int id;
    double basicDiscount;
    double volumeDiscount10k;
    double volumeDiscount30k;

    public Customer(int id, double basicDiscount, double volumeDiscount10k, double volumeDiscount30k) {
        this.id = id;
        this.basicDiscount = basicDiscount;
        this.volumeDiscount10k = volumeDiscount10k;
        this.volumeDiscount30k = volumeDiscount30k;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasicDiscount() {
        return basicDiscount;
    }

    public void setBasicDiscount(double basicDiscount) {
        this.basicDiscount = basicDiscount;
    }

    public double getVolumeDiscount10k() {
        return volumeDiscount10k;
    }

    public void setVolumeDiscount10k(double volumeDiscount10k) {
        this.volumeDiscount10k = volumeDiscount10k;
    }

    public double getVolumeDiscount30k() {
        return volumeDiscount30k;
    }

    public void setVolumeDiscount30k(double volumeDiscount30k) {
        this.volumeDiscount30k = volumeDiscount30k;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", basicDiscount=" + basicDiscount +
                ", volumeDiscount10k=" + volumeDiscount10k +
                ", volumeDiscount30k=" + volumeDiscount30k +
                '}';
    }
}
