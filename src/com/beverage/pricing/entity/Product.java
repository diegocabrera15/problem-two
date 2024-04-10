package com.beverage.pricing.entity;

public class Product {
    private String name;
    private double unitCost;
    private double markup;
    private String markupType;
    private double promotion;
    private double unitPrice;

    public Product(String name, double unitCost, double markup, String markupType, double promotion) {
        this.name = name;
        this.unitCost = unitCost;
        this.markup = markup;
        this.markupType = markupType;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public String getMarkupType() {
        return markupType;
    }

    public void setMarkupType(String markupType) {
        this.markupType = markupType;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
