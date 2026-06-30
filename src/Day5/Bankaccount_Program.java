package Day5;



	class BankAccount {

	    long accountNumber;
	    String accountHolderName;
	    double balance;

	    // Default Constructor
	    BankAccount() {
	        accountNumber = 0;
	        accountHolderName = "Unknown";
	        balance = 0.0;
	    }

	    // Parameterized Constructor
	    BankAccount(long accountNumber, String accountHolderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.balance = balance;
	    }

	    // Method to deposit money
	    void deposit(double amount) {
	        balance = balance + amount;
	        System.out.println("₹" + amount + " deposited successfully.");
	    }

	    // Method to withdraw money
	    void withdraw(double amount) {

	        if (amount <= balance) {
	            balance = balance - amount;
	            System.out.println("₹" + amount + " withdrawn successfully.");
	        } else {
	            System.out.println("Insufficient balance!");
	        }
	    }

	    // Method to display account details
	    void displayDetails() {
	        System.out.println("Account Number : " + accountNumber);
	        System.out.println("Account Holder : " + accountHolderName);
	        System.out.println("Balance        : ₹" + balance);
	        System.out.println();
	    }
	}
	
	 public class Bankaccount_Program {
		 
	    public static void main(String[] args) {

	        // Creating objects using different constructors
	        BankAccount acc1 = new BankAccount(); // Default constructor
	        BankAccount acc2 = new BankAccount(1234567890L, "Pratik Kale", 10000);

	        // Display initial details
	        acc1.displayDetails();
	        acc2.displayDetails();

	        // Perform transactions
	        acc2.deposit(5000);
	        acc2.withdraw(3000);

	        // Display updated details
	        acc2.displayDetails();
	    }
	}

