import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class Course {
    private Instructor instuctor;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private String room;
    private DayOfWeek courseDay;
    private LocalTime time;
    private int duration;
    private int maxStudents;
    private ArrayList<Student> students;

    public Course(String courseCode, String courseName, String courseDescription, String room, Instructor instuctor, DayOfWeek courseDay,
                  LocalTime time, int duration, int maxStudents){
        int times = time.getHour();
        if(instuctor.canTeach(courseCode) && maxStudents >= 10 && maxStudents <= 50 && times >= 8 && times <= 18) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.courseDescription = courseDescription;
            this.room = room;
            this.instuctor = instuctor;
            this.courseDay = courseDay;
            this.time = time;
            this.duration = duration;
            setMaxNumberOfStudents(maxStudents);
            students = new ArrayList<>();
        }else{
            throw new IllegalArgumentException("Not valid");
        }
    }

    /**
     * adds a new student and validates that the student is in good standing and that the array list size is not
     * bigger than the maxNumber of students allowed in the class
     */
    public void addStudent(Student student1){
        if (student1.inGoodStanding() && students.size() < maxStudents){
            students.add(student1);
        }else{
            throw new IllegalArgumentException("Student Must be in good standing");
        }
    }

    /**
     * returns the average time a student spent at school
     */
    public double averageStudentTimeAtCollege(){
        double averageTime = 0.0;
        for (Student student : students){
            averageTime += student.getYearsAtCollege();
        }
        return averageTime/students.size();
    }

    /**
     * gets the object Instructor
     */
    public Instructor getProf() {
        return instuctor;
    }

    /**
     * gets the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * gets the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * gets the course description
     */
    public String getDescription() {
        return courseDescription;
    }

    /**
     * gets the room number
     */
    public String getRoom() {
        return room;
    }

    /**
     * gets the course day
     */
    public DayOfWeek getDayOfClass() {
        return courseDay;
    }

    /**
     * gets the time of the class
     */
    public LocalTime getStartTime() {
        return time;
    }

    /**
     * gets the class duration
     */
    public int getDuration(){
        return duration;
    }

    /**
     * gets the max number of students allowed in a class
     */
    public int getMaxNumberOfStudents() {
        return maxStudents;
    }

    /**
     * gets the number of students that are enrolled
     */
    public int getNumberOfStudentsEnrolled(){
        return students.size();
    }

    /**
     * gets the students contained in the array list
     */
    public ArrayList getStudents(){
        return students;
    }

    /**
     * sets the day on which the class is held and validates that it is not a saterday or sunday
     */
    public void setDayOfClass(DayOfWeek classDay){
        String dayOfWeek = classDay.toString();
        if(!dayOfWeek.equalsIgnoreCase("Saturday") && !dayOfWeek.equalsIgnoreCase("Sunday")) {
            courseDay = classDay;
        }else {
            throw new IllegalArgumentException("no valid days to hold class");
        }
    }

    /**
     * sets the max number of students allowed in the class and validates that there is 10 to 50
     */
    public void setMaxNumberOfStudents(int maxClassSize){
        if (maxClassSize >= 10 && maxClassSize <= 50){
            maxStudents = maxClassSize;
        }else{
            throw new IllegalArgumentException("Class size must be greater than 10 and less than 50");
        }
    }

    /**
     * sets the instructor and validates that they can teach the class
     */
    public void setProf(Instructor instuctor1){
        if (instuctor1.canTeach(courseCode)){
            instuctor = instuctor1;
        }else{
            throw new IllegalArgumentException("Instuctor is no allowed to teach");
        }
    }

    /**
     * sets the start time of the class and validates that it is between 8 and 6
     */
    public void setStartTime(LocalTime startTime){
        int start = startTime.getHour();
        if (start >= 8 && start <= 18) {
            this.time = startTime;
        }else{
            throw new IllegalArgumentException("must be between 8am and 6pm");
        }
    }

    /**
     * returns the class list as a string
     */
    public String showClassList(){
        String studentList = "";
        for (Student student : students){
            studentList += student + String.format("%n");
        }
        return studentList;
    }

    /**
     * returns the course name and course code as a string
     */
    public String toString(){
        return courseName + " " + courseCode;
    }
}
