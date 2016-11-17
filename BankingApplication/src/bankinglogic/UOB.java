/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinglogic;





/**
 *
 * @author Student
 */
public class UOB {

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        if (accountType == "Savings Account" || accountType == "Current Account")
        this.accountType = accountType;
        else{
            System.out.println("Invalid Account Type..:");
            this.accountType = "Invalid Acount";
        }
        
        
    }

    /**
     * @return the accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @return the accountActive
     */
    public boolean isAccountActive() {
        return accountActive;
    }

    /**
     * @param accountActive the accountActive to set
     */
    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }
    //put attributes and methods
    
    private int accountNumber = 1000;
    private String accountName = "Victor Lee";
    private String accountType = "";
    private double accountBalance = 0.0;
    private boolean accountActive = true;
    public static final int CLOSING_MONTHS = 12;
    public StringBuilder bankDisclaimer = new StringBuilder("Disclaimer blah blah blah");//this is a String but mutable because of StringBuilder
    //public String [] bankBranches = new String[3]; //declare and instantiate new array
    public String [] bankBranches = {"North", "South", "East"};
    
    public void deposit(double depositAmount){
        double interestRate = 0.10;//this is a local variable visible only to this method
        //Normal if statement without ternary operator
        /*double bonusAmount;
        if (depositAmount >= 10_000)
            bonusAmount = depositAmount * interestRate;
        else bonusAmount = 0.0;
        accountBalance += (depositAmount + bonusAmount);
        */
        //Use ternary operator
        double bonusAmount = (depositAmount >= 10_000) ? (depositAmount * interestRate) : 0.0;
        accountBalance += (depositAmount + bonusAmount);
    }
    
    //Add two parameters to method
    public void withdrawal(double withdrawalAmount,
            double withdrawalLimit){
        //Combined if else statement
        /*if (withdrawalAmount >= 2000 && accountType == "Savings Account") {
            System.out.println("Sorry, you exceeded withdrawal limit. Please try again tomorrow." );
            
        }else {
            accountBalance -= withdrawalAmount;
        }
    
        //Nesting if else statement
        if (withdrawalAmount >= 2000) {
            if (accountType == "Savings Account")
                System.out.println("Sorry, you exceeded withdrawal limit. Please try again tomorrow." );
                }
                else
            accountBalance -= withdrawalAmount;
        */
        
        
        //Chaining if statement
        if (withdrawalAmount >=withdrawalLimit && getAccountType() == "Savings Account")
            System.out.println("You exceeded withdrawal limit...");
        else if (withdrawalAmount <= 0)
            System.out.println("Error: Please enter a valid withdrawal amount");
        else
            accountBalance -= withdrawalAmount;
    
    }
    
    public void displayTransaction(){
    System.out.println("Account No:" + getAccountNumber());
    System.out.println("Account Name:" + getAccountName());
    System.out.println("Account Type:" + getAccountType());
    System.out.println("New Account Balance:" + getAccountBalance());
    System.out.println("Account Status:" + isAccountActive());
    //System.out.println("Disclaimer:" + bankDisclaimer);
    
    String disclaimerInCaps = bankDisclaimer.toString();
    System.out.println(disclaimerInCaps.toUpperCase());
    closingMonthInWord();
    //display bank branches
    System.out.println("Bank Branches:");
    System.out.println(bankBranches[0]);
    System.out.println(bankBranches[1]);
    System.out.println(bankBranches[2]);
    }
    
    public void closingMonthInWord(){
        int month = CLOSING_MONTHS;
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println("Closing month: " + monthString);
    }
    
    //This is a function that returns something of a data type.  It is not void. 
    public static String bankPolicy(){
        return "No deposits less than 1000...";
    }
}
