
public class CollegeStudent extends Student {

    private boolean graduateEligable;

    //    Override the constructor
    public CollegeStudent(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public void isGraduateEligable() {

        int totCredits = 0;
        int gradeCutoff = 70;
        boolean passed = true;

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) {
                totCredits += courses[i].getNumberOfCredits();
            }
            if (courses[i].getGrade() < gradeCutoff) {
                passed = false;
            }

        }
        if (passed && totCredits >= 132){
            graduateEligable = true;
        } else {
            graduateEligable = false;
        }
    }

    public void printGraduateStatus() {
        if (graduateEligable) {
            System.out.println("Can Graduate!");
        } else {
            System.out.println("Nope, failed.");
        }
    }
}
