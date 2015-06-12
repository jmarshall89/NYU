
public class Course {

    private long courseId;
    private String description;
    private String instructor;
    private int numberOfCredits;
    private int grade;

    public Course(long courseId, String description, String instructor){
        this.courseId = courseId;
        this.description = description;
        this.instructor = instructor;
    }

    public Course(long courseId, String description,
                  String instructor, int numberOfCredits) {
        this(courseId, description, instructor);
        this.numberOfCredits = numberOfCredits;
    }

//    Getters
    public long getCourseId() {
        return courseId;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public int getGrade() {
        return grade;
    }

//    Setters
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString(){

        String val;
        String nl = "/n";

        val =   "Course ID: " + courseId + nl +
                "Description: " + description + nl +
                "Instructor: " + instructor + nl +
                "Number of Credits" + numberOfCredits + nl +
                "Grade: " + grade;
        return val;
    }



}
