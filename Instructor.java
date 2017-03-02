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
        if (employeeNum > 0) {
            this.employeeNum = employeeNum;
            this.hireDate = hireDate;
            teachableCourse = new ArrayList<>();
        }else {
            throw new IllegalArgumentException("Employeee number is invalid");
        }
    }

    public void addTeachableCourse(String courseCode) {
        teachableCourse.add(courseCode.toUpperCase());
    }

    public boolean canTeach(String courseCode) {
        if (teachableCourse.contains(courseCode.toUpperCase())) {
            return true;
        }else{
            return false;
        }
    }

    public int getYearsAtCollege() {
        LocalDate enrolled = LocalDate.now();
        return Period.between(hireDate, enrolled).getYears();
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
    public ArrayList getTeachableCourses(){

        return teachableCourse;
    }
    public String listOfSubjectsCertifiedToTeach(){
        StringBuilder courselist = new StringBuilder();
        for (int i = 0; i < teachableCourse.size()-1; i++) {
             courselist.append(teachableCourse.get(i).toString());
            courselist.append(", ");
        }
        courselist.append(teachableCourse.get(+1).toString());
        return String.valueOf(courselist);
    }
    public void setBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        int age = Period.between(birthday, today).getYears();
        if (age >= 18 && age < 100) {
            super.setBirthday(birthday);
        } else {
            throw new IllegalArgumentException("Employees must be 18-100 years old");
        }
    }

    public void setHireDate(LocalDate hireDate) {
        LocalDate today = LocalDate.now();
        int yearsHired = Period.between(hireDate, today).getYears();
        System.out.println(yearsHired);
        if (yearsHired <= 80 && yearsHired > 0) {
            this.hireDate = hireDate;
        } else {
            throw new IllegalArgumentException("sorry your waaaaay to old jaret or are you an time traveler dunnn dunn duuuuhnnnnn");
        }
    }

}