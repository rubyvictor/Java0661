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
    
    public void deposit(long depositAmount){
        double interestRate = 0.10;//this is a local variable visible only to this method
        accountBalance += (depositAmount + (depositAmount * (long)(interestRate)));
    }
            
    public void withdrawal(double withdrawalAmount){
        //interestRate = 0.50;this method cannot access the interestRate var in deposit method
        accountBalance -= withdrawalAmount;
    }
    
    public void displayTransaction(){
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
    
    
    
    }
}
