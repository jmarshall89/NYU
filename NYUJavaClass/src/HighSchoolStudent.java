
public class HighSchoolStudent extends Student {

    private boolean graduateEligable;

//    Override the constructor
    public HighSchoolStudent(String firstname, String lastname) {
        super(firstname, lastname);
    }

//    Overrides the abstract method in student
    public void isGraduateEligable() {
        int classCount = 0;
        int gradeCutoff = 70;
        boolean passed = true;

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) {
                classCount++;

                if (courses[i].getGrade() < gradeCutoff) {
                    passed = false;
                }
            }
        }

        if (passed && classCount >= 24) {
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
