import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
    public static int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public static double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! \n", userName);
        System.out.printf("There are %s people in front of you \n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart1(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%s - %.2f\n", i, (price * i));
        }
    }

    public void printPriceChart2(String product, double price, double discount, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%s - %.2f\n", i, (price * i) - ((i - 1) * discount));
        }
    }
}
