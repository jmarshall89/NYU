
public abstract class Student {

//	Private Static fields
	private static int classNumber;
	private static String className;
	private static String instructor;
	private static int studentCount = 0;     // this count allows us to increment studentId below
										 // note there is no getter or setter for this field
	
//	Private instance fields
	private int studentId = 999;
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String email;
	Course[] courses = new Course[50];
	
//	Short constructor
	public Student(String firstname, String lastname) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		classNumber = 1;
		className = "Intermediate Java";
		instructor = "Sam Sultan";
		studentCount++;
		studentId = studentId + studentCount;
		
	}
	
//	Long constructor
	public Student(String firstname, String lastname, String address, 
			       String city, String state, String email) {
		
//		Call the short constructor
		this(firstname, lastname);
		
//		set the other fields
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
	
	}
	
//	toString class
	public String toString() {
		
//		Create a new line variable
		String nl = " ";
		String coursesTaken = "";

//		Loop through array of courses and print those which the student has taken
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {
				if (coursesTaken == "") {
					coursesTaken = "" + courses[i].getCourseId();
				} else {
					coursesTaken += ", " + courses[i].getCourseId();
				}
			}
		}

		String info = "Class Name: " + className + nl +
		"Class Instructor: " + instructor + nl +
		"Class Number: " + classNumber + nl +
		"Student Name: " + firstname + " " + lastname + nl +
		"Student ID: " + studentId + nl +
		"Student Email " + email + nl +
		"Address:" + nl +
		address + nl +
		city + ", " + state + nl +
		"Courses taken: " + coursesTaken;
		
		return info;
	}
	
//	Getter and setter methods for static fields
	public static int getClassNumber() {
		return classNumber;
	}
	public static void setClassNumber(int classNumber) {
		Student.classNumber = classNumber;
	}
	public static String getClassName() {
		return className;
	}
	public static void setClassName(String className) {
		Student.className = className;
	}
	public static String getInstructor() {
		return instructor;
	}
	public static void setInstructor(String instructor) {
		Student.instructor = instructor;
	}
//	Getter and setter methods for instance fields
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addCourse(Course course){
//		Find where the next null value is
		int i = 0;

		while(courses[i] != null){
			i++;
		}
		courses[i] = course;
	}

	abstract void isGraduateEligable();
	abstract void printGraduateStatus();

	public void printCourses() {
		for (int i = 0; i < courses.length; i++) {
			if ( courses[i] != null ){
				System.out.println(courses[i].toString());
			}
		}
	}
	
	
	
}
