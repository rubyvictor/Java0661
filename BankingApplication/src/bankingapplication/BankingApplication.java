/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import bankinglogic.CitiBank;
import bankinglogic.UOB;
import java.util.ArrayList;

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
        
        //UOB Transaction
        UOB firstUOBCustomer;
        firstUOBCustomer = new UOB(); //Object reference available. create a class constructor and new copies will be put into the object UOB.
        
        firstUOBCustomer.accountNumber = 1000;
        //use parsing of data into the String[] args
        //inside terminal: java BankingApplication 1000 "Eva Longoria"
        //firstUOBCustomer.accountNumber = Integer.parseInt(args[0]);
        firstUOBCustomer.accountName = "Eva Longoria";
        //firstUOBCustomer.accountName = args[1];
        firstUOBCustomer.accountType = "Savings Account";
        firstUOBCustomer.deposit(1000);
        firstUOBCustomer.withdrawal(100,2000);
        firstUOBCustomer.bankDisclaimer.append(" For UOB ...");
        firstUOBCustomer.displayTransaction();
        
        
        
        UOB secondUOBCustomer = new UOB();
        secondUOBCustomer.accountNumber = 2000;
        secondUOBCustomer.accountName = "Jack Ryan";
        secondUOBCustomer.accountType = "Current Account";
        secondUOBCustomer.deposit(500);
        secondUOBCustomer.withdrawal(-20,2000);
        secondUOBCustomer.bankDisclaimer.append(" For UOB...");
        secondUOBCustomer.displayTransaction();
    
        //Store UOB Customers into an array. This is better done in separate data class
        UOB [] UOBCustomers = {firstUOBCustomer, secondUOBCustomer};
        //Use ArrayList to store UOB Customers. can store any data type. Object Type. Can store both citibank and UOB customers.
        
        
        
        //Object anything = "A";
        //not good practice to box or cast to unbox. lying to Java.
        //int mynumber = (int)anything;//boxing process will not work. anything is unknown, not an int. So need to CAST to unbox.
        
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
        firstCitiCustomer.withdrawal(100,2000);
        firstCitiCustomer.bankDisclaimer.append(" For CitiBank ...");
        firstCitiCustomer.displayTransaction();
        
        ArrayList bankCustomers = new ArrayList();
        bankCustomers.add(firstUOBCustomer);
        bankCustomers.add(secondUOBCustomer);
        //bankCustomers.add(firstCitiCustomer);
        
        
        //Making a twin
        CitiBank secondCitiCustomer = firstCitiCustomer;
        secondCitiCustomer.accountName = "FantasticFour";
        System.out.println("From firstCitiCustomer" + firstCitiCustomer.accountName);
        
        //Store CitiCustomers into an array. This should be done in separate data class.
        CitiBank [] CitiCustomers = {firstCitiCustomer,secondCitiCustomer};
        
        //Summary list of all banking customers
        //Use Object Casting to accomodate the ArrayList.  Cast with UOB and Cast with CitiBank in order to access the fields inside ArrayList
        System.out.println("*****Summary of Bank customers*****");
        //Use a Loop to minimize code duplication
        //Use a size() function to get the length of the collection if you don't know
        
//        int itemNumber = 0;
//        while (itemNumber < bankCustomers.size() -1) {
//        System.out.println(((UOB)(bankCustomers.get(itemNumber))).accountNumber);
//        System.out.println((((UOB)(bankCustomers.get(itemNumber)))).accountName);
//        ++itemNumber;
//        }
        //Another way using for loop
//        for (int itemNumber2 = 0; itemNumber2 < bankCustomers.size()-1;++itemNumber2){
//            System.out.println(((UOB)(bankCustomers.get(itemNumber2))).accountNumber);
//        System.out.println((((UOB)(bankCustomers.get(itemNumber2)))).accountName);
//        }
        
        //Enhanced ForLoop - element types must match data types in the Forloop
        //For ArrayList, the data type is Object, not UOB nor CitiBank
        //For Casting of different type of Objects, eg. UOB or CitiBank Objects, can find out first. KEYWORD: instance of. 
        for (Object customer: bankCustomers) {
            
            if (((UOB)customer).accountType == "Current Account"){
//            System.out.println("Customer found with " + ((UOB)customer).accountType);
                //break;// cannot be used for filtering, because break already can't see other customers with savings account
                break;//Use to force another iteration and skip codes after Continue
            }
        
            System.out.println("Account Number is: " + ((UOB)customer).accountNumber);
            System.out.println("Account Name is: " + ((UOB)customer).accountName);
            System.out.println("AccountType is: " + ((UOB)customer).accountType);
        }
        
            
        
   
        
        /*System.out.print(((UOB)(bankCustomers.get(0))).accountNumber);
        System.out.println(((UOB)bankCustomers.get(0)).accountName);
        System.out.print(((UOB)(bankCustomers.get(1))).accountNumber);
        System.out.println(((UOB)bankCustomers.get(1)).accountName);
        System.out.print(((CitiBank)(bankCustomers.get(2))).accountNumber);
        System.out.println(((CitiBank)bankCustomers.get(2)).accountName);
        */
        System.out.println("***********************************");
        
    }
    
}
