import java.time.LocalDate;
import java.time.Period;

/**
 * Created by John on 2017-02-26.
 */
public class Student extends Person{
    LocalDate enrollmentDate;
    String major;
    int studentNumber;
    boolean goodstanding;

    /**
     * constuctor for the Student Class
     */
    public Student(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate dateOfBirth, String major, int studentNumber, LocalDate
                   enrollmentDate){
        //super from the main class person
        super(firstName, lastName, streetAddress, city, province, postalCode, dateOfBirth);
        //validates that the student number is greater than 0
        if (studentNumber > 0) {
            this.enrollmentDate = enrollmentDate;
            this.major = major;
            this.studentNumber = studentNumber;
            goodstanding = true;
            setBirthday(dateOfBirth);
        }else{
            throw new IllegalArgumentException("Student number must be greater than 0");
        }

    }

    /**
     * get method for the year that the student enrolled in the college
     *@return the year that the student has been enrolled at the college
     */
    public int getYearEnrolled() {
       int yearEnrolled = enrollmentDate.getYear();
        return yearEnrolled;
    }

    /**
     * get method for years the student has been enrolled
     * @return returns how many years that the student has been enrolled for
     */
    public int getYearsAtCollege(){
        LocalDate enrolled = LocalDate.now();
        return Period.between(enrollmentDate, enrolled).getYears();
    }

    /**
     * this method lets you know if the student is in good standing or not
     * @return true if the student is in good standing and false if they are not
     */
    public boolean inGoodStanding(){
       if (goodstanding == true) {
           return true;
       } else{
               return false;
       }
    }

    /**
     * this method sets goodstanding equal to false to show that the student has been suspended
     * @return false
     */
    public boolean suspendStudent(){
        goodstanding = false;
        return false;
    }

    /**
     * this method reinstates a suspended student
     * @return true
     */
    public boolean reinstateStudent(){
        goodstanding = true;
            return true;
    }

    /**
     * this method sets the birthdate and validates that the age of the
     * student is between 14 and 90 years old
     */
    public void setBirthday(LocalDate birthday){
        LocalDate today = LocalDate.now();
        int age = Period.between(birthday, today).getYears();
        if(age >= 14 && age <= 90){
            super.setBirthday(birthday);
        } else {
            throw new IllegalArgumentException("Employees must be 14-90 years old");
        }
    }

    /**
     * this method sets the student the student number and validates that it is greater than 0
     */
    public void setStudentNumber(int studentNum){
        if (studentNum >= 0) {
            studentNumber = studentNum;
        }else{
            throw new IllegalArgumentException("Student num must be greater than 0");
        }
    }

    /**
     * this method changes the address from the super class person
     */
    public void changeAddress(String street, String city, String province, String postalCode) {
        super.changeAddress(street, city, province,postalCode);

    }

    /**
     * this method overides the toString() method in the super class
     * and returns the first and last name of the student and the student number.
     */
    @Override
    public String toString(){
    return String.format("%s, student number is %d", super.toString(), studentNumber);
    }
}
