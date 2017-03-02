import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * Created by John on 2017-02-27.
 */
public class Instructor extends Person {
    private int employeeNum;
    private LocalDate hireDate;
    private ArrayList<String> teachableCourse;

    //constructor for the Instructor class
    public Instructor(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate dateOfBirth,
                      int employeeNum, LocalDate hireDate) {
        super(firstName, lastName, streetAddress, city, province, postalCode, dateOfBirth);
        //validates the employee number is greater than 0a
        if (employeeNum > 0) {
            this.employeeNum = employeeNum;
            this.hireDate = hireDate;
            teachableCourse = new ArrayList<>();
        }else {
            throw new IllegalArgumentException("Employeee number is invalid");
        }
    }

    /**
     * adds a course to the array list of teachable courses
     */
    public void addTeachableCourse(String courseCode) {
        teachableCourse.add(courseCode.toUpperCase());
    }

    /**
     * checks and sees if the course is in the teachable course array list and
     * returns true if it is and false if it is not
     */
    public boolean canTeach(String courseCode) {
        if (teachableCourse.contains(courseCode.toUpperCase())) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * gets the how many years it has been since the instructor was hired and today
     */
    public int getYearsAtCollege() {
        LocalDate today = LocalDate.now();
        return Period.between(hireDate, today).getYears();
    }

    /**
     * gets the employee number
     */
    public int getEmployeeNum() {
        return employeeNum;
    }

    /**
     * gets the local date object hire date
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * gets the array list of teachable courses
     */
    public ArrayList getTeachableCourses(){
        return teachableCourse;
    }

    /**
     * returns all of the courses in the array list of teachable courses as a string
     * with a space and an comma in between
     */
    public String listOfSubjectsCertifiedToTeach(){
        StringBuilder courselist = new StringBuilder();
        for (int i = 0; i < teachableCourse.size()-1; i++) {
             courselist.append(teachableCourse.get(i).toString());
            courselist.append(", ");
        }
        courselist.append(teachableCourse.get(+1).toString());
        return String.valueOf(courselist);
    }

    /**
     * sets the birthday and valadates that the instructor is between 18-100 years old
     */
    public void setBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        int age = Period.between(birthday, today).getYears();

        if (age >= 18 && age < 100) {
            super.setBirthday(birthday);
        } else {
            throw new IllegalArgumentException("Employees must be 18-100 years old");
        }
    }

    /**
     * sets the hire date and validates that the hire date is less than 80 years ago and not in the future
     */
    public void setHireDate(LocalDate hireDate) {
        LocalDate today = LocalDate.now();
        int yearsHired = Period.between(hireDate, today).getYears();

        if (yearsHired <= 80 && yearsHired > 0) {
            this.hireDate = hireDate;
        } else {
            throw new IllegalArgumentException("sorry your waaaaay to old jaret or are you an time traveler dunnn dunn duuuuhnnnnn");
        }
    }

}
