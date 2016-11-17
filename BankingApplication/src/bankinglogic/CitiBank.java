/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankinglogic;

/**
 *
 * @author victorlee
 */
public class CitiBank {

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
    private int accountNumber = 4000;
    private String accountName = "Victor Lee";
    private String accountType = "";
    private double accountBalance = 0.0;
    private boolean accountActive = true;
    public static final int CLOSING_MONTHS = 12;
    public StringBuilder bankDisclaimer = new StringBuilder("Disclaimer blah blah blah");//this String is mutable due to StringBuilder
    //public String [] bankBranches = new String[4];
    public String [] bankBranches = {"North", "South","East", "West"};
            
    public void deposit(double depositAmount){
        double interestRate = 0.10;//this is a local variable visible only to this method
        
        double bonusAmount = (depositAmount >= 20_000) ? (depositAmount * interestRate) : 0.0;
        accountBalance += (depositAmount + bonusAmount);
    }
            
    public void withdrawal(double withdrawalAmount,
            double withdrawalLimit){
        //interestRate = 0.50;this method cannot access the interestRate var in deposit method
        
        if (withdrawalAmount >= withdrawalLimit && getAccountType() == "Savings Account")
            System.out.println("You exceeded withdrawal limit...");
        else if (withdrawalAmount <= 0)
            System.out.println("Error: Please enter a valid withdrawal amount");
        else
            accountBalance -= withdrawalAmount;
       
    }
    
    public void displayTransaction(){
    System.out.println();
    System.out.println("Account No:" + getAccountNumber());
    System.out.println("Account Name:" + getAccountName());
    System.out.println("Account Type:" + getAccountType());
    System.out.println("New Account Balance:" + getAccountBalance());
    System.out.println("Account Status:" + isAccountActive());
    //System.out.println("Bank Disclaimer:" + bankDisclaimer);
    String disclaimerInCaps = bankDisclaimer.toString();
    System.out.println(disclaimerInCaps.toUpperCase());
    //StringBuilder capacity practice
    StringBuilder myString = new StringBuilder();
    myString.append("asdfghjklpoiuytrew");
    System.out.println("length" + myString.length());
    System.out.println("capactiy" + myString.capacity());
    closingMonthInWord();
    //display bank branches
    System.out.println("Bank Branches:");
    System.out.println(bankBranches[0]);
    System.out.println(bankBranches[1]);
    System.out.println(bankBranches[2]);
    System.out.println(bankBranches[3]);
    
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
        System.out.println("Closing Month: " + monthString);
    }
    
    //This is a function that returns something of a data type.  It is not void. It can be made Static. 
    public static String bankPolicy(){
        return "No deposits less than 1000...";
    }


}
