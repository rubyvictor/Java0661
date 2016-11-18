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
       
        //instantiate an instance of the UOB class ie create an object which will hold a copy of the object - need to import bankinglogic package
        //or can fully qualify without import but repetitive.  bankinglogic.UOB firstUOBCustomer;
        
        //UOB Transaction.  Overloading all banking transactions into one method.
        UOB firstUOBCustomer;
        firstUOBCustomer = new UOB(); //Object reference available. create a class constructor and new copies will be put into the object UOB.
        
        Transactions(firstUOBCustomer, 1000, "Eva Longoria", "Savings Account", 1000, 5000);
        
        //Static: Call the class UOB for closing months without instantiating.
        //System.out.println(Banks.CLOSING_MONTHS);//With constructor, this is not possible
        
        UOB secondUOBCustomer = new UOB();
        Transactions(secondUOBCustomer, 2000, "Jack Ryan", "Current Account", 500, 20);
        
        //to test constructor calling with parameters, must remove the static in variable
        //Constructor practice
        UOB thirdUOBCustomer = new UOB(1);
        UOB fourthUOBCustomer = new UOB(2);
        
        //Store UOB Customers into an array. This is better done in separate data class
        UOB [] UOBCustomers = {firstUOBCustomer, secondUOBCustomer};
        //Use ArrayList to store UOB Customers. can store any data type. Object Type. Can store both citibank and UOB customers.
        
        
        
        //Object anything = "A";
        //not good practice to box or cast to unbox. lying to Java.
        //int mynumber = (int)anything;//boxing process will not work. anything is unknown, not an int. So need to CAST to unbox.
        
//        UOB thirdUOBCustomer = secondUOBCustomer; // make thirdUOBCustomer a twin of secondUOBCustomer to avoid having to manually instantiating all the variables again for thirdUOBCustomer
        secondUOBCustomer.setAccountNumber(3000);
        thirdUOBCustomer.setAccountNumber(4000);
        System.out.println("From second UOB customer" + secondUOBCustomer.getAccountNumber());
        
        //CitiBank Transactions
        CitiBank firstCitiCustomer = new CitiBank(); //Object reference available. create a class constructor and new copies will be put into the object UOB.
        Transactions(firstCitiCustomer, 8000, "Donald Trump", "Current Account", 20000, 100);
    
        //Create ArrayList of bankCustomers
        ArrayList bankCustomers = new ArrayList();
        bankCustomers.add(firstUOBCustomer);
        bankCustomers.add(secondUOBCustomer);
        
        
        //Making a twin
        CitiBank secondCitiCustomer = firstCitiCustomer;
        secondCitiCustomer.setAccountName("FantasticFour");
        System.out.println("From firstCitiCustomer" + firstCitiCustomer.getAccountName());
        
        //Store CitiCustomers into an array. This should be done in separate data class.
        CitiBank [] CitiCustomers = {firstCitiCustomer,secondCitiCustomer};
        
        //Summary list of all banking customers
        //Use Object Casting to accomodate the ArrayList.  Cast with UOB and Cast with CitiBank in order to access the fields inside ArrayList
        System.out.println("*****Summary of Bank customers*****");
        //Use a Loop to minimize code duplication
        //Use a size() function to get the length of the collection if you don't know
        
        //OPTION 1: WHILE LOOP
//        int itemNumber = 0;
//        while (itemNumber < bankCustomers.size() -1) {
//        System.out.println(((UOB)(bankCustomers.get(itemNumber))).accountNumber);
//        System.out.println((((UOB)(bankCustomers.get(itemNumber)))).accountName);
//        ++itemNumber;
//        }
        //OPTION 2: FOR LOOP
//        for (int itemNumber2 = 0; itemNumber2 < bankCustomers.size()-1;++itemNumber2){
//            System.out.println(((UOB)(bankCustomers.get(itemNumber2))).accountNumber);
//        System.out.println((((UOB)(bankCustomers.get(itemNumber2)))).accountName);
//        }
        
        //OPTION 3: Enhanced ForLoop with nested If - element types must match data types in the Forloop
        //For ArrayList, the data type is Object, not UOB nor CitiBank
        //For Casting of different type of Objects, eg. UOB or CitiBank Objects, can find out first. KEYWORD: instance of. 
        for (Object customer: bankCustomers) {
            
            if (((UOB)customer).getAccountType() != "Current Account"){
//            System.out.println("Customer found with " + ((UOB)customer).accountType);
                //break;// cannot be used for filtering, because break already can't see other customers with savings account
                continue;//Use "continue" to force another iteration and skip codes after Continue
            }
        
            System.out.println("Account Number is: " + ((UOB)customer).getAccountNumber());
            System.out.println("Account Name is: " + ((UOB)customer).getAccountName());
            System.out.println("AccountType is: " + ((UOB)customer).getAccountType());
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
//CREATE METHODS TO HOUSE UOB AND CITIBANK TRANSACTIONS - OVERLOADING. same method name with different signatures
    public static void Transactions (UOB UOBCustomer, int acctNo, String acctName, String acctType, double depoAmount, double withAmount)
    {
        UOBCustomer.setAccountNumber(acctNo);
        UOBCustomer.setAccountName(acctName);
        UOBCustomer.setAccountType(acctType);
        UOBCustomer.deposit(depoAmount);
        UOBCustomer.withdrawal(withAmount,3000);
        UOBCustomer.bankDisclaimer.append(" For UOB ...");
        UOBCustomer.displayTransaction();
        System.out.println(UOB.bankPolicy());//STATIC: call UOB class directly without instantiating.
        System.out.println(UOBCustomer);
    }
    
public static void Transactions (CitiBank CitiCustomer, int acctNo, String acctName, String acctType, double depoAmount, double withAmount)
    {
        CitiCustomer.setAccountNumber(acctNo);
        CitiCustomer.setAccountName(acctName);
        CitiCustomer.setAccountType(acctType);
        CitiCustomer.deposit(depoAmount);
        CitiCustomer.withdrawal(withAmount,2000);
        CitiCustomer.bankDisclaimer.append(" For CitiBank ...");
        CitiCustomer.displayTransaction();
        System.out.println(CitiBank.bankPolicy());//STATIC: call CitiBank class directly without instantiating. 
        System.out.println(CitiCustomer);
    }

}