import java.time.LocalDate;
import java.time.Period;

/**
 * Created by John on 2017-02-13.
 */
public class Person {

    private String firstName, lastName, streetAddress, city, province, postalCode;
    private LocalDate dateOfBirth;

    /**
     * constructor for the program that validates the postal code has a length of 6
     */
    public Person(String firstName, String lastName, String streetAddress, String city, String province, String postal,
                  LocalDate dateOfBirth)
    {
        if (postal.length() == 6) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.streetAddress = streetAddress;
            this.city = city;
            this.province = province;
            this.postalCode = postal;
            this.dateOfBirth = dateOfBirth;
        }else{
            throw new IllegalArgumentException("Invalid Postal Code must be at 6 characters long");
        }
    }

    /**
     * @return this method returns the persons first and last name as a string
     */
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * this method get the persons age in years from a LocalDate
     */
    public int getAge()
    {
        LocalDate today = LocalDate.now();
        //Period object                   //method getYears() returns an int
        return Period.between(dateOfBirth, today).getYears();
    }

    /**
     * this method will return the full address street address, city, province, and postal code
     */
    public String getFullAddress(){

        return streetAddress + ", "+ city + ", " + province + ", " + postalCode;
    }

    /**
     * @return get that returns the first name as a string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return get that returns the last name as a string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return get that returns the street address as a string
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @return get that returns the city as a string
     */
    public String getCity() {
        return city;
    }

    /**
     * @return get that returns the province as a string
     */
    public String getProvince() {
        return province;
    }

    /**
     * @return get that returns the postal code as a string
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @return get that returns the dateofbirth as a local date
     */
    public LocalDate getBirthday() {
        return dateOfBirth;
    }

    /**
     * sets the first name of the person
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * sets the last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * sets the streetaddress of the person
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * sets the city of the persoon
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * sets the province of the person
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * sets the birthdate of the person
     */

    public void setBirthday(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * gets how old the person is
     * @return year
     */
    public int getYearBorn() {

        int year  = dateOfBirth.getYear();
        return year;
    }

    /**
     * this method is to validate that the postal code is equal to 6 and that it is a valid postal code
     * and set it to uppercase
     */

    public void setPostalCode(String postal) {

        String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";

        postal = postal.toUpperCase();

        if(postal.length() == 6 && postal.matches(regex)){
            postalCode = postal;
        }else {
            throw new IllegalArgumentException("Not a valid postal Code");
        }

    }

    /**
     * this method changes the address of the person and validates that it has a valid
     * postal code
     */
    public void changeAddress(String street, String city, String province, String postalCode) {
        if (postalCode.length() == 6) {
            streetAddress = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        }else{
            throw new IllegalArgumentException("Bad postal code");
        }
    }
}
