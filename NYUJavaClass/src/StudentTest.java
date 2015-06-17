
public class StudentTest {

    public static void main(String[] args) {

        Student[] students = new Student[50];

        students[0] = new HighSchoolStudent("Katie", "Stansell");
        students[1] = new HighSchoolStudent("Mack", "Jarvis");
        students[2] = new HighSchoolStudent("Sam", "Veach");
        students[3] = new CollegeStudent("Barry", "Stec");
        students[4] = new CollegeStudent("Chris", "Kempel");
        students[5] = new CollegeStudent("David", "Clarke");

////        Create some courses, and a new one for each student
//        Course algebra = new Course(1234, "Basic number game", "Hall");
//        Course english = new Course(1235, "Spelling and grammar", "Fignerski");
//        Course art = new Course(1236, "Learning about art", "Scott");
//        Course calculus = new Course(101, "Don't drink and derieve", "Bayne", 50);
//        Course business = new Course(103, "Learn about business", "Whaley", 50);
//        Course philosphy = new Course(203, "Get an easy A", "Toto", 50);

        /*  All high school student will take the high school classes, and all the college students
            will take the college classes

            The grades will be set by a normal distribution with a mean of 85 and standard deviation
            of 5
            */

        double mean = 85.0f;
        double stdev = 5.0f;
        RandomGrade grade = new RandomGrade(mean, stdev);

        /* This is not a solid way to actually add courses. A more complicated yet solid way
        would be to have a private static final value in each student subclass which tells the
        type of student, then do a switch-case to add the right classes.
         */
        for (int i = 0; i < 3; i++){
//        Create some courses, and a new one for each student
            Course tempAlgebra = new Course(1234, "Basic number game", "Hall");
            Course tempEnglish = new Course(1235, "Spelling and grammar", "Fignerski");
            Course tempArt = new Course(1236, "Learning about art", "Scott");
            students[i].addCourse(tempAlgebra);
            students[i].addCourse(tempEnglish);
            students[i].addCourse(tempArt);
        }

        for (int i = 3; i <= 5; i++) {
            Course tempCalculus = new Course(101, "Don't drink and derieve", "Bayne", 50);
            Course tempBusiness = new Course(103, "Learn about business", "Whaley", 50);
            Course tempPhilosphy = new Course(203, "Get an easy A", "Toto", 50);
            students[i].addCourse(tempCalculus);
            students[i].addCourse(tempBusiness);
            students[i].addCourse(tempPhilosphy);
        }

//        now set the grade for the courses
        for (int i = 0; i < students.length; i++){
            if (students[i] != null) {
//                now loop through the courses
                for (int j = 0; j < students[i].courses.length; j++){
                    if (students[i].courses[j] != null) {
                        students[i].courses[j].setGrade(grade.classGrade());
                    }
                }
            }
        }

//        Now print student info and graduation eligabilty

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i].isGraduateEligable();
                students[i].printCourses();
                students[i].printGraduateStatus();
            }
        }
    }
}