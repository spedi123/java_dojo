public class Test {
    public static void main(String[] args) {
        
        Item item1 = new Item("mocha", 4.49);
        Item item2 = new Item("latte", 4.29);
        Item item3 = new Item("drip coffee", 3.29);
        Item item4 = new Item("capuccino", 4.29);

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Peter");
        Order order4 = new Order("Esther");
        Order order5 = new Order("Riley");

        order1.addItem(item1);
        order1.addItem(item2);
        // ready is false
        System.out.println(order1.getStatusMessage());
        // ready is true
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());
        // order total
        System.out.println(order1.getOrderTotal());
        
        order3.addItem(item3);
        order3.addItem(item4);
        order3.dispay();
    }
}