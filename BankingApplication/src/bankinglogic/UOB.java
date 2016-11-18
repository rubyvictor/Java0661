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
//constructors need to be specific to each class
//THis CHILD can call the Parent class constructor
public class UOB extends Banks {

    public UOB(){
       super();//make a call to the constructor of the parent
    }
    
    public UOB(int month){
        super();
    }
    
    
   // override the bank's generic deposit method for UOB.
    //use super because the base class already has private variable called deposit. Take it from there.
    @Override //good practice to add this annotation
    public void deposit(double depositAmount){
        double interestRate = 0.10;
        super.deposit(depositAmount +(depositAmount * interestRate));
        System.out.println("Bonus added for UOB Customers");
    }

    
}
