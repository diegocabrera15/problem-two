import com.beverage.pricing.entity.Customer;
import com.beverage.pricing.entity.Product;
import com.beverage.pricing.util.LoadConfig;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.000");
        LoadConfig loadConfig = new LoadConfig();
        ArrayList<Customer> customers = loadConfig.loadConfigCustomers();
        ArrayList<Product> products = loadConfig.loadConfigProducts();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer ID (1-5):");
        int customerId = scanner.nextInt();
        Customer customer = loadConfig.findCustomer(customers, customerId);

        if (customer != null){
            System.out.println("Enter quantity of product A:");
            int quantityA = scanner.nextInt();

            System.out.println("Enter quantity of product B:");
            int quantityB = scanner.nextInt();

            System.out.println("Enter quantity of product C:");
            int quantityC = scanner.nextInt();

            System.out.println("Enter quantity of product D:");
            int quantityD = scanner.nextInt();

            double totalBeforeDiscount = loadConfig.calculateTotalPrice(products, quantityA, quantityB, quantityC, quantityD);
            double totalAfterDiscount = loadConfig.applyDiscounts(totalBeforeDiscount, customer);

            System.out.println("\nOrder Summary:");
            System.out.println("Product\t\tQuantity\tUnit Price\tTotal EUR");
            System.out.println("A\t\t\t" + quantityA + "\t\t" + decimalFormat.format(loadConfig.calculateUnitPrice(products.get(0), quantityA)) + "\t\t" + decimalFormat.format(loadConfig.calculateTotalUnitPrice(products.get(0), quantityA)));
            System.out.println("B\t\t\t" + quantityB + "\t\t\t" + decimalFormat.format(loadConfig.calculateUnitPrice(products.get(1), quantityB)) + "\t\t" + decimalFormat.format(loadConfig.calculateTotalUnitPrice(products.get(1), quantityB)));
            System.out.println("C\t\t\t" + quantityC + "\t\t" + decimalFormat.format(loadConfig.calculateUnitPrice(products.get(2), quantityC)) + "\t\t" + decimalFormat.format(loadConfig.calculateTotalUnitPrice(products.get(2), quantityC)));
            System.out.println("D\t\t\t" + quantityD + "\t\t\t" + decimalFormat.format(loadConfig.calculateUnitPrice(products.get(3), quantityD)) + "\t\t\t" + decimalFormat.format(loadConfig.calculateTotalUnitPrice(products.get(3), quantityD)));

            System.out.println("\nTotal amount before customer discounts: " + totalBeforeDiscount + " EUR");
            System.out.println("Total amount after customer discounts: " + totalAfterDiscount + " EUR");

            scanner.close();
        }else{
            System.out.println("Invalid customer ID");
        }

    }
}