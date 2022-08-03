import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();


    public Order() {
        this.name = "Guest";
        this.ready = false;
    }

    public Order(String name) {
        this.name = name;
        this.ready = false;
    }

    public String getName() {
        return name;
    }

    public boolean getReady() {
        return ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (this.ready == true) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double totalAmount = 0;
        for(Item item : this.items) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
    }

    public void dispay() {
        System.out.printf("Customer Name : %s \n", name);
        for (Item item : this.items) {
            System.out.println(item.getName() + " - $ " + item.getPrice());
        }
        System.out.println("Total : $ " + this.getOrderTotal());
    }
}