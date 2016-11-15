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
    //put attributes and methods
    
    public int accountNumber = 224466;
    public String accountName = "Victor Lee";
    public String accountType = "";
    public double accountBalance = 0.0;
    public boolean accountActive = true;
 
    
    public void deposit(double depositAmount){
        accountBalance += depositAmount;
    }
            
    public void withdrawal(double withdrawalAmount){
        accountBalance -= withdrawalAmount;
    }
    
    public void displayTransaction(){
    System.out.println("Account No:" + accountNumber);
    System.out.println("Account Name:" + accountName);
    System.out.println("Account Type:" + accountType);
    System.out.println("New Account Balance:" + accountBalance);
    System.out.println("Account Status:" + accountActive);
    
    }
    
}
