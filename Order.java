import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private List<Product> products;
    private double totalPrice;

    public Order(User user) {
        this.user = user;
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addProduct(Product product) {
        if (product.isAvailable()) {
            products.add(product);
            totalPrice += product.getPrice();
            product.decreaseStock();
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
        product.increaseStock();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }
}
