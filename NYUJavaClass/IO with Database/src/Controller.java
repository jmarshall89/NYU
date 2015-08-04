import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jmarshall on 7/27/15.
 */
public class Controller {

    public String nameCompare() {
        Model m = new Model();
        View v = new View();

        String lName = v.getUserInput();
        ResultSet rs = m.getDbName();

        try {

            ArrayList<StudentInfo> studentLists = new ArrayList<>();
            while (rs.next()) {
                if (dbMatch(rs, lName)) {
                    studentLists.add(setStudentInfo(rs));
                }
            }

            rs.close();

            String output = convertArrayList(studentLists);


        } catch (Exception e) {
            System.out.println(e);
        }

    }



    private boolean dbMatch(ResultSet rs, String lname) {
        try {
            String dbName = rs.getString("lname").toLowerCase();
            lname = lname.toLowerCase();

            return dbName.equals(lname);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private StudentInfo setStudentInfo(ResultSet rs) {

        try {
            StudentInfo si = new StudentInfo();
            si.setFname(rs.getString("fname"));
            si.setId(rs.getInt("student_id"));
            si.setLname(rs.getString("lname"));
            si.setSsn(rs.getString("ssn"));
            si.setSex(rs.getString("sex"));

            return si;
        } catch (Exception e) {

            System.out.println(e);
        }
        return null;
    }

    private String convertArrayList(ArrayList<StudentInfo> list) {
        String output = "";
        String nl = "\n";
        if (list.isEmpty()) {
            return output;
        }

        Iterator<StudentInfo> listIT = list.iterator();

        while (listIT.hasNext()) {
            output += "Student ID: " + listIT.next().getId() + nl;
            output += "Student First Name: " + listIT.next().getFname() + nl;
            output += "Student Last Name: " + listIT.next().getLname() + nl;
            output += "Student SSN: " + listIT.next().getSsn() + nl;
            output += "Student Sex: " + listIT.next().getSex() + nl;
            output += "-------------------" + nl;

        }

        return output;
    }


}
