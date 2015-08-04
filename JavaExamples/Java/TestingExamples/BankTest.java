package TestingExamples;

import Java.main.Bank;
import Java.main.DBManager;
import mockit.NonStrictExpectations;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jmarshall on 8/4/15.
 */
public class BankTest {

    @Test
    public void testTetrieveAccountHolderName() {

        Bank bank = new Bank();

        new NonStrictExpectations() {
            DBManager dbManager;
            {
                dbManager.retrieveAccountHolderName(10); returns("Bill");
            }
        };

        String name = bank.processAccount(10);

        assertEquals("Bill", name);
    }


}
