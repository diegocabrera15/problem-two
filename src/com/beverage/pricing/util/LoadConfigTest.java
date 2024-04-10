package com.beverage.pricing.util;
import com.beverage.pricing.entity.Customer;
import com.beverage.pricing.entity.Product;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;

public class LoadConfigTest {
    LoadConfig loadConfig = new LoadConfig();
    ArrayList<Customer> customers = new ArrayList<>();
    Customer customer;
    ArrayList<Product> products = new ArrayList<>();
    double totalBeforeDiscount = 0.0;
    @Test
    public void findCustomerSuccessfully() {
        loadConfig = new LoadConfig();

        LoadConfigCustomerTest(customers);
        int customerId = 1;
        customer = loadConfig.findCustomer(customers, customerId);
        assertNotNull(customer);
    }

    @Test
    public void calculateTotalPriceSuccessfully() {
        loadConfig = new LoadConfig();
        LoadConfigProductTest(products);

        int quantityA = 10000;
        int quantityB = 20000;
        int quantityC = 40000;
        int quantityD = 0;
        double totalBeforeDiscount = loadConfig.calculateTotalPrice(products, quantityA, quantityB, quantityC, quantityD);
        assertNotNull(totalBeforeDiscount);
    }

    @Test
    public void applyDiscountsSuccessfully() {
        int customerId = 2;
        LoadConfigCustomerTest(customers);
        customer = loadConfig.findCustomer(customers, customerId);
        System.out.println("customer aaa: " + customer);
        double totalAfterDiscount = loadConfig.applyDiscounts(totalBeforeDiscount, customer);
        assertNotNull(totalAfterDiscount);
    }


    static void LoadConfigProductTest(ArrayList<Product> products) {
        products.add(new Product("A", 0.52, 0.80, MarkupType.PERCENTAGE.name(),  0));
        products.add(new Product("B", 0.38, 1.20, MarkupType.PERCENTAGE.name(), 0.30));
        products.add(new Product("C", 0.41, 0.90, MarkupType.UNIT.name(), 0));
        products.add(new Product("D", 0.60, 1.00, MarkupType.UNIT.name(), 0.20));
    }

    static void LoadConfigCustomerTest(ArrayList<Customer> customers) {
        customers.add(new Customer(1, 0.05, 0.00, 0.02));
        customers.add(new Customer(2, 0.04, 0.01, 0.02));
        customers.add(new Customer(3, 0.03, 0.01, 0.03));
        customers.add(new Customer(4, 0.02, 0.03, 0.05));
        customers.add(new Customer(5, 0.00, 0.05, 0.07));
    }
}
