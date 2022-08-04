public class Bank {
    private double checkingBalance;
    private double savingBalance;
    public static int numberOfAccount = 0;
    public static double totalAmount = 0;

    // constructor
    public Bank(double checkingBalance, double savingBalance) {
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numberOfAccount++;
    }

    public Bank() {
        this.checkingBalance = 0;
        this.savingBalance = 0;
        numberOfAccount ++;
    }

    // getter and setter
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingBalance(){
        return this.savingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public void deposit(double money, String accountType) {
        if (accountType == "saving") {
            savingBalance += money;
            totalAmount += money;
        } else {
            checkingBalance += money;
            totalAmount += money;
        }
    }

    public void deposit(double money, String accountType) {
       if (accountType == "saving" && totalAmount < money) {
            System.out.println("Not enough money at your saving");
        } else if (accountType == "checking" && totalAmount < money) {
            System.out.println("Not enough money at your checking");
        } else {
            if (accountType == "saving") {
                savingBalance -= money;
                totalAmount -= money;
            } else {
                checkingBalance -= money;
                totalAmount -= money;
            }
        }
    }

    public double getTotal() {
        return totalAmount;
    }
}