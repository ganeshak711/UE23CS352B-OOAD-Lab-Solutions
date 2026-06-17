import java.util.Scanner;

// Base Class
class FoodOrder {
    protected int orderId;
    protected String customerName;
    protected double basePrice;

    FoodOrder(int orderId, String customerName, double basePrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.basePrice = basePrice;
    }

    double calculateFinalPrice() {
        return basePrice;
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.printf("Final Price: %.2f", calculateFinalPrice());
    }
}

// Dine In Order
class DineInOrder extends FoodOrder {
    DineInOrder(int orderId, String customerName, double basePrice) {
        super(orderId, customerName, basePrice);
    }

    @Override
    double calculateFinalPrice() {
        return basePrice + (basePrice * 0.10);
    }
}

// TakeAway Order
class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(int orderId, String customerName, double basePrice) {
        super(orderId, customerName, basePrice);
    }

    @Override
    double calculateFinalPrice() {
        return basePrice + 50;
    }
}

// Delivery Order
class DeliveryOrder extends FoodOrder {
    DeliveryOrder(int orderId, String customerName, double basePrice) {
        super(orderId, customerName, basePrice);
    }

    @Override
    double calculateFinalPrice() {
        return basePrice + 40 + (basePrice * 0.05);
    }
}

public class Inheritance_Overriding_Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > 3) return;

        if (!sc.hasNextInt()) return;
        int orderId = sc.nextInt();
        sc.nextLine();

        if (orderId < 1 || orderId > 1000000) return;

        String customerName = sc.nextLine();

        if (!sc.hasNextDouble()) return;
        double basePrice = sc.nextDouble();

        if (basePrice < 0 || basePrice > 1000000) return;

        FoodOrder order = null;

        switch (choice) {
            case 1:
                order = new DineInOrder(orderId, customerName, basePrice);
                break;
            case 2:
                order = new TakeAwayOrder(orderId, customerName, basePrice);
                break;
            case 3:
                order = new DeliveryOrder(orderId, customerName, basePrice);
                break;
            default:
                return;
        }

        order.displayOrderDetails();
        sc.close();
    }
}
