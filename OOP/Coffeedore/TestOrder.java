import java.util.ArrayList;

public class TestOrder {
    public static void main(String[] args) {
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();
    
        coffeeKiosk.addMenuItem("Mocha", 4.99);
        coffeeKiosk.addMenuItem("Latte", 4.29);
        coffeeKiosk.addMenuItem("Drip Coffee", 3.79);
        coffeeKiosk.addMenuItem("Capuccino", 4.29);
    
        // coffeeKiosk.addMenuItemByInput();
        coffeeKiosk.newOrder();
    }
}