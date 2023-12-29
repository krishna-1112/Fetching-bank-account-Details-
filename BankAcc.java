import java.util.Scanner;

class BankAcc{
    private double balance;
    public BankAcc(double intBalance) {
        balance = intBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Money deposited"+amount);
        }
        else{
            System.out.println("Invalid deposit");
        }
    }
    public void withdraw(double amount){
        if (amount>0 && amount<balance){
            balance-=amount;
            System.out.println("Amount Withdrawn"+amount);
        }
        else{
            System.out.println("Invalid withdrawal");
        }
    }
    
    public static void main(String[] args) {
        BankAcc userAccount = new BankAcc(1000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
class ATM {
    private BankAcc account;
    private Scanner scanner;

    public ATM(BankAcc account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void ShowMenu() {
        System.out.println("WELCOME TO ATM");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit money");
        System.out.println("3.Withdraw money");
        System.out.println("4.Exit");
    }

    public void start() {
        int choice;
        do {
            System.out.println("Enter your choice");
            ShowMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM.Thank you ");
            }
        } while (choice != 4);

    }

    private void checkBalance() {
        System.out.println("Current Account Balance" + account.getBalance());
    }

    private void deposit() {
        System.out.println("Enter deposit money");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.println("Enter money to withdraw");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
class Main {
    public static void main(String[] args) {
        BankAcc userAccount = new BankAcc(1000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}