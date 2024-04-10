package com.beverage.pricing.util;

import com.beverage.pricing.entity.Customer;
import com.beverage.pricing.entity.Product;

import java.util.ArrayList;

public class LoadConfig {

    public LoadConfig() {
    }

    public ArrayList<Product> loadConfigProducts(){
        ArrayList<Product> products = new ArrayList<>();
        LoadConfigTest.LoadConfigProductTest(products);

        return products;
    }

    public ArrayList<Customer> loadConfigCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        LoadConfigTest.LoadConfigCustomerTest(customers);

        return customers;
    }

    public Customer findCustomer(ArrayList<Customer> customers, int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    public double calculateTotalPrice(ArrayList<Product> products, int quantityA, int quantityB, int quantityC, int quantityD) {
        double totalPrice = 0;

        totalPrice += (products.get(0).getUnitCost() * quantityA * (1 + products.get(0).getMarkup()) * (1 - products.get(0).getPromotion()));
        totalPrice += (products.get(1).getUnitCost() * quantityB * (1 + products.get(1).getMarkup()) * (1 - products.get(1).getPromotion()));
        totalPrice += (products.get(2).getUnitCost() * quantityC * (1 + products.get(2).getMarkup()) * (1 - products.get(2).getPromotion()));
        totalPrice += (products.get(3).getUnitCost() * quantityD * (1 + products.get(3).getMarkup()) * (1 - products.get(3).getPromotion()));

        return totalPrice;
    }

    public double calculateTotalUnitPrice(Product products, int productQuantity) {
        return (products.getUnitCost() * productQuantity * (1 + products.getMarkup()) * (1 - products.getPromotion()));
    }

    public double calculateUnitPrice(Product products, int productQuantity) {
        double unitPrice;
        if (productQuantity > 0) {
            unitPrice = (products.getUnitCost() * productQuantity * (1 + products.getMarkup()) * (1 - products.getPromotion()))/productQuantity;
            return unitPrice;
        }
        return 0;
    }

    public double applyDiscounts(double totalPrice, Customer customer) {
        double basicDiscount = customer.getBasicDiscount();
        double volumeDiscount10k = customer.getVolumeDiscount10k();
        double volumeDiscount30k = customer.getVolumeDiscount30k();

        // Apply basic discount
        totalPrice *= (1 - basicDiscount);
        System.out.println("total price: " + totalPrice);
        // Apply additional volume discount
        if (totalPrice > 30000) {
            totalPrice *= (1 - volumeDiscount30k);
        } else if (totalPrice > 10000) {
            totalPrice *= (1 - volumeDiscount10k);
        }

        return totalPrice;
    }

}
