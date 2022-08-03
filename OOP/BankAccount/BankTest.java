public class BankTest{
    public static void main (String[] args) {
        Bank user1 = new Bank();
        user1.deposit(100, "saving");
        user1.deposit(200, "checking");
        user1.withdraw(20, "saving");
        user1.withdraw(40, "checking");

        Bank user2 = new Bank();
        user2.deposit(200, "saving");
        user2.deposit(100, "checking");
        user2.withdraw(30, "saving");
        user2.withdraw(30, "checking");


        System.out.println(user1.getSavingBalance());
        System.out.println(user1.getCheckingBalance());
        System.out.println(user1.getTotal());

        System.out.println(user2.getSavingBalance());
        System.out.println(user2.getCheckingBalance());
        System.out.println(user2.getTotal());
    }
}