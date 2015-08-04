/**
 * Created by jmarshall on 8/4/15.
 */
public class Bank {
    DBManager dbManager = new DBManager();

    public String processAccount(int acctID) {
        String accountHolderName = dbManager.retrieveAccountHolderName(acctID);
        return accountHolderName;
    }
}
