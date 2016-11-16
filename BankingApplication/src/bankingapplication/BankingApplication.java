/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import bankinglogic.CitiBank;
import bankinglogic.UOB;

/**
 *
 * @author Student
 */
public class BankingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //instantiate an instance of the UOB class ie create an object which will hold a copy of the object - need to import bankinglogic package
        //or can fully qualify without import but repetitive.  bankinglogic.UOB firstUOBCustomer;
        UOB firstUOBCustomer;
        firstUOBCustomer = new UOB(); //Object reference available. create a class constructor and new copies will be put into the object UOB.
        
        firstUOBCustomer.accountNumber = 1000;
        firstUOBCustomer.accountName = "Eva Longoria";
        firstUOBCustomer.accountType = "Savings Account";
        firstUOBCustomer.deposit(1000);
        firstUOBCustomer.withdrawal(100);
        firstUOBCustomer.bankDisclaimer.append(" For UOB ...");
        firstUOBCustomer.displayTransaction();
        
        
        
        UOB secondUOBCustomer = new UOB();
        secondUOBCustomer.accountNumber = 2000;
        secondUOBCustomer.accountName = "Jack Ryan";
        secondUOBCustomer.accountType = "Current Account";
        secondUOBCustomer.deposit(500);
        secondUOBCustomer.withdrawal(-20);
        secondUOBCustomer.bankDisclaimer.append(" For UOB...");
        secondUOBCustomer.displayTransaction();
    
        UOB thirdUOBCustomer = secondUOBCustomer; // make thirdUOBCustomer a twin of secondUOBCustomer to avoid having to manually instantiating all the variables again for thirdUOBCustomer
        secondUOBCustomer.accountNumber = 3000;
        thirdUOBCustomer.accountNumber = 4000;
        System.out.println("From second UOB customer" + secondUOBCustomer.accountNumber);
        
    //CitiBank Transactions
    CitiBank firstCitiCustomer = new CitiBank(); //Object reference available. create a class constructor and new copies will be put into the object UOB.
        
        firstCitiCustomer.accountNumber = 8000;
        firstCitiCustomer.accountName = "Donald Trump";
        firstCitiCustomer.accountType = "Entrepreneur Account";
        firstCitiCustomer.deposit(20_000);
        firstCitiCustomer.withdrawal(100);
        firstCitiCustomer.bankDisclaimer.append(" For CitiBank ...");
        
        
        firstCitiCustomer.displayTransaction();
        
        
        CitiBank secondCitiCustomer = firstCitiCustomer;
        secondCitiCustomer.accountName = "Tom Cruise";
        System.out.println("From firstCitiCustomer" + firstCitiCustomer.accountName);
    }
    
}
