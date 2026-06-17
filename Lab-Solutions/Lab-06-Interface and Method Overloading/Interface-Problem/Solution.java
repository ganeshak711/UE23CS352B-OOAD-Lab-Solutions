import java.util.Scanner;

interface Product {
    String getName();
    double getPrice();
    void displayDetails();
}

class Electronics implements Product {
    private String name;
    private double price;
    private int warranty;

    Electronics(String name, double price, int warranty) {
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Category: Electronics");
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f\n", price);
        System.out.println("Warranty: " + warranty + " months");
    }
}

class Grocery implements Product {
    private String name;
    private double price;
    private String expiry;

    Grocery(String name, double price, String expiry) {
        this.name = name;
        this.price = price;
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Category: Grocery");
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f\n", price);
        System.out.println("Expiry Date: " + expiry);
    }
}

class Clothing implements Product {
    private String name;
    private double price;
    private String size;

    Clothing(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Category: Clothing");
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f\n", price);
        System.out.println("Size: " + size);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        Product p = null;

        switch(choice) {
            case 1:
                String eName = sc.nextLine();
                double ePrice = sc.nextDouble();
                int warranty = sc.nextInt();
                p = new Electronics(eName, ePrice, warranty);
                break;
            case 2:
                String gName = sc.nextLine();
                double gPrice = sc.nextDouble();
                sc.nextLine();
                String expiry = sc.nextLine();
                p = new Grocery(gName, gPrice, expiry);
                break;
            case 3:
                String cName = sc.nextLine();
                double cPrice = sc.nextDouble();
                sc.nextLine();
                String size = sc.nextLine();
                p = new Clothing(cName, cPrice, size);
                break;
            default:
                sc.close();
                return;
        }
        p.displayDetails();
        sc.close();
    }
}
