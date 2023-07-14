import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EcommercePlatform {
    private Map<String, String> userCredentials;
    private List<User> users;
    private List<Product> products;

    public EcommercePlatform() {
        this.userCredentials = new HashMap<>();
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();

        // Add electronics products
        addProduct("Phone", "Smartphone", 999.99, 100);
        addProduct("Laptop", "Gaming Laptop", 1499.99, 50);
        addProduct("TV", "Smart TV", 799.99, 75);
        addProduct("Tablet", "Android Tablet", 299.99, 80);
        addProduct("Headphones", "Wireless Headphones", 199.99, 120);
        addProduct("Camera", "Digital Camera", 599.99, 35);
        addProduct("Speaker", "Bluetooth Speaker", 149.99, 100);
        addProduct("Monitor", "Computer Monitor", 299.99, 60);
        addProduct("Smartwatch", "Fitness Smartwatch", 199.99, 90);
        addProduct("Gaming Console", "Video Game Console", 499.99, 25);
        addProduct("Router", "Wireless Router", 99.99, 150);
        addProduct("Printer", "All-in-One Printer", 199.99, 40);
        addProduct("Keyboard", "Mechanical Keyboard", 149.99, 80);
        addProduct("Mouse", "Gaming Mouse", 79.99, 100);
        addProduct("Camera Lens", "Interchangeable Lens", 499.99, 20);
        addProduct("Hard Drive", "External Hard Drive", 129.99, 70);
        addProduct("Wireless Earbuds", "True Wireless Earbuds", 149.99, 100);
        addProduct("Power Bank", "Portable Charger", 49.99, 200);
        addProduct("Projector", "HD Projector", 699.99, 30);
    }

    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public User authenticateUser(String username, String password) {
        String storedPassword = userCredentials.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return new User(username, password);
        }
        return null;
    }


    private void addProduct(String name, String description, double price, int stock) {
        Product newProduct = new Product(name, description, price, stock);
        products.add(newProduct);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
