import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by jmarshall on 7/27/15.
 */
public class Model {
    
    public ResultSet getDbName() {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String hostDB = "jdbc:oracle:thin:@localhost:1521:app11g";
            Connection con = DriverManager.getConnection(hostDB, "marshalj", "jm123890");

            Statement stmt = con.createStatement();
            String sql = getSQL();
            ResultSet rs = stmt.executeQuery(sql);

            stmt.close();
            con.close();
            return rs;

        }
        catch (Exception e) {
            System.out.print(e);
        }

        return null;
    }

    private String getSQL() {
        return "SELECT * FROM student";
    }




//    public StudentInfo setStudent(something somehting){
//    }

}
