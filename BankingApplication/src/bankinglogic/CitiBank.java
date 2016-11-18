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
//child class must override parent abstract methods because parent class is an Abstract class
//make class final to prevent Citibank from becoming a PARENT
public final class CitiBank extends Banks {

    public CitiBank(){
       super();
    }
    
    public CitiBank(int month){
        super();
    }
    
    
    public void citiBankPromotion(){
        System.out.println("CitiBank customers get an insurance for each deposit");
        
    }

    //implement abstractMethod to override parent abstract method
    @Override
    public void abstractMethod() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
