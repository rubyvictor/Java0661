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
public interface ITransactions {

    String BANKDISCLAIMER = "Disclaimer...";//BY DEFAULT FINAL
    
    
    void closingMonthInWord();

    void deposit(double depositAmount);

    void displayTransaction();

    /**
     * @return the accountBalance
     */
    double getAccountBalance();

    /**
     * @return the accountName
     */
    String getAccountName();

    /**
     * @return the accountNumber
     */
    int getAccountNumber();

    /**
     * @return the accountType
     */
    String getAccountType();

    /**
     * @return the accountActive
     */
    boolean isAccountActive();

    /**
     * @param accountActive the accountActive to set
     */
    void setAccountActive(boolean accountActive);
    //put attributes and methods

    /**
     * @param accountName the accountName to set
     */
    void setAccountName(String accountName);

    /**
     * @param accountNumber the accountNumber to set
     */
    void setAccountNumber(int accountNumber);

    /**
     * @param accountType the accountType to set
     */
    //COnfigure interface to throw exception too
    void setAccountType(String accountType) throws Exception;

    //Add two parameters to method
    //make method final to prevent child from overriding it OR prevent subclassing
    void withdrawal(double withdrawalAmount, double withdrawalLimit);
    
}
