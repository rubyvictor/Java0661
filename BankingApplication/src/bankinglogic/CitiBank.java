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
    public int accountNumber = 4000;//public is an access modifier.  Use public to make this var accessible in the same class or package
    public String accountName = "Victor Lee";//if no public access modifier, then var becomes local accessible within this class only
    public String accountType = "";
    public double accountBalance = 0.0;
    public boolean accountActive = true;
    public final int CLOSING_MONTHS = 1;
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
        
        if (withdrawalAmount >= withdrawalLimit && accountType == "Savings Account")
            System.out.println("You exceeded withdrawal limit...");
        else if (withdrawalAmount <= 0)
            System.out.println("Error: Please enter a valid withdrawal amount");
        else
            accountBalance -= withdrawalAmount;
       
    }
    
    public void displayTransaction(){
    System.out.println();
    System.out.println("Account No:" + accountNumber);
    System.out.println("Account Name:" + accountName);
    System.out.println("Account Type:" + accountType);
    System.out.println("New Account Balance:" + accountBalance);
    System.out.println("Account Status:" + accountActive);
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
    
    //This is a function that returns something of a data type.  It is not void. 
    public String bankPolicy(){
        return "No deposits less than 1000...";
    }


}
