/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import bankinglogic.Banks;
import bankinglogic.CPF;
import bankinglogic.CitiBank;
import bankinglogic.ITransactions;
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
        UOB thirdUOBCustomer = new UOB(1);//set closing month to 1 or January
        UOB fourthUOBCustomer = new UOB(2);
        
        Banks fifthUOBCustomer = new UOB();//parent class can hold copies of child classes
        
        
        //Store UOB Customers into an array. This is better done in separate data class
//        UOB [] UOBCustomers = {firstUOBCustomer, secondUOBCustomer};
        //Use ArrayList to store UOB Customers. can store any data type. Object Type. Can store both citibank and UOB customers.
        
        
        
        //Object anything = "A";
        //not good practice to box or cast to unbox. lying to Java.
        //int mynumber = (int)anything;//boxing process will not work. anything is unknown, not an int. So need to CAST to unbox.
        
//        UOB thirdUOBCustomer = secondUOBCustomer; // make thirdUOBCustomer a twin of secondUOBCustomer to avoid having to manually instantiating all the variables again for thirdUOBCustomer
        secondUOBCustomer.setAccountNumber(3000);
        thirdUOBCustomer.setAccountNumber(4000);
//        System.out.println("From second UOB customer" + secondUOBCustomer.getAccountNumber());
        
        //CitiBank Transactions
        CitiBank firstCitiCustomer = new CitiBank(); //Object reference available. create a class constructor and new copies will be put into the object UOB.
        Transactions(firstCitiCustomer, 8000, "Donald Trump", "Current Account", 20000, 100);
    
        //Constructor parent can hold child copy
//        Banks secondCitiCustomer = new CitiBank();
//        Banks thirdCitiCustomer = firstCitiCustomer;
        
        //Create ArrayList of bankCustomers
        ArrayList bankCustomers = new ArrayList();
        bankCustomers.add(firstUOBCustomer);
        bankCustomers.add(secondUOBCustomer);
        bankCustomers.add(thirdUOBCustomer);
        bankCustomers.add(firstCitiCustomer);
        
        //Add CPF transactions
        CPF firstCPFCustomer = new CPF();
        Transactions(firstCPFCustomer, 5000,"Michael Erich", "Special Account", 2000, 100);
        
        
        //Making a twin
//        CitiBank secondCitiCustomer = firstCitiCustomer;
//        secondCitiCustomer.setAccountName("FantasticFour");
//        System.out.println("From firstCitiCustomer" + firstCitiCustomer.getAccountName());
        
        //Store CitiCustomers into an array. This should be done in separate data class.
//        CitiBank [] CitiCustomers = {firstCitiCustomer,secondCitiCustomer};
        
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
            
            if (((Banks)customer).getAccountType() != "Current Account"){
//            System.out.println("Customer found with " + ((UOB)customer).accountType);
                //break;// cannot be used for filtering, because break already can't see other customers with savings account
                continue;//Use "continue" to force another iteration and skip codes after Continue
            }
        
            System.out.println("Account Number is: " + ((Banks)customer).getAccountNumber());
            System.out.println("Account Name is: " + ((Banks)customer).getAccountName());
            System.out.println("AccountType is: " + ((Banks)customer).getAccountType());
        }
        
            
        
   
        
        /*System.out.print(((UOB)(bankCustomers.get(0))).accountNumber);
        System.out.println(((UOB)bankCustomers.get(0)).accountName);
        System.out.print(((UOB)(bankCustomers.get(1))).accountNumber);
        System.out.println(((UOB)bankCustomers.get(1)).accountName);
        System.out.print(((CitiBank)(bankCustomers.get(2))).accountNumber);
        System.out.println(((CitiBank)bankCustomers.get(2)).accountName);
        */
        System.out.println("***********************************");
        //prints memory address for CPF customer
        System.out.println("A CPF customer: " + firstCPFCustomer);
    }
//CREATE METHODS TO HOUSE UOB AND CITIBANK TRANSACTIONS - OVERLOADING. same method name with different signatures
    //Use Interface to get transactions for either banks or CPF
    public static void Transactions (ITransactions Customer, int acctNo, String acctName, String acctType, double depoAmount, double withAmount)
    {
        System.out.println(Banks.bankPolicy());
        Customer.setAccountNumber(acctNo);
        Customer.setAccountName(acctName);
        Customer.setAccountType(acctType);
        Customer.deposit(depoAmount);
        Customer.withdrawal(withAmount,3000);
        
        //Parent checks for correct disclaimer using instanceof keyword
        //Need to cast Banks on customer to get bankDisclaimer variable since the interface doesn't have variables
        if (Customer instanceof UOB){
            ((Banks)Customer).bankDisclaimer.append(" For UOB ...");
        }else {
            if (Customer instanceof CitiBank){
            
            ((Banks)Customer).bankDisclaimer.append(" For CitiBank ...");
            ((CitiBank)Customer).citiBankPromotion();//something only for CitiBank Customers
            }
            else {
            if (Customer instanceof CPF){
                ((CPF)Customer).bankDisclaimer.append(" For CPF....");
                }
            }
        }
        Customer.displayTransaction();
        
        System.out.println();
        
    }
    


}