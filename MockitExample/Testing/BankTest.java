import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by jmarshall on 8/4/15.
 */
@RunWith(JMockit.class)
public class BankTest {

    @Test
    public void testRetireveAccountHolderName(
            @Mocked final DBManager dbmanager
    ) {
        Bank bank = new Bank();

        new Expectations() {

            {
                dbmanager.retrieveAccountHolderName(10); returns("Bill");
            }
        };
        String name = bank.processAccount(10);
        assertEquals("Bill", name);
    }


}
