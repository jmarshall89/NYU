/**
 * Created by jmarshall on 7/27/15.
 */
public class Controller {

    public String nameCompare() {
        Model m = new Model();
        View v = new View();

    //    Somehow data gets pulled from a database
//      The user also enters data
        String usrInputName;
        String dbName;

        dbName = m.getDbName();
        usrInputName = v.getUserInput();


}

    public boolean isMatch(String dbName, String usrInputName) {

        dbName = dbName.toLowerCase();
        usrInputName = usrInputName.toLowerCase();



    }

}
