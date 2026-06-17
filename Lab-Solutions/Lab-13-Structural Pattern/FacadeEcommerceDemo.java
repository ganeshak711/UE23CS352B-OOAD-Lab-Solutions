// Solution 4: E-Commerce Platform
// Pattern: Facade

// Subsystems
class LoginService {
    void login() { System.out.println("User logged in"); }
}

class ProductService {
    void selectProduct() { System.out.println("Product selected"); }
}

class PaymentService {
    void makePayment() { System.out.println("Payment successful"); }
}

class OrderService {
    void trackOrder() { System.out.println("Order tracking started"); }
}

// Facade
class EcommerceFacade {
    private LoginService   login   = new LoginService();
    private ProductService product = new ProductService();
    private PaymentService payment = new PaymentService();
    private OrderService   order   = new OrderService();

    void completePurchase() {
        login.login();
        product.selectProduct();
        payment.makePayment();
        order.trackOrder();
    }
}

// Client
public class FacadeEcommerceDemo {
    public static void main(String[] args) {
        EcommerceFacade facade = new EcommerceFacade();
        facade.completePurchase();
    }
}
