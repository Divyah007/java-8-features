package java8.features;

/*
* 1. generate getters and setters
* 2. generate all argument constructor
* 3. override toString() method--> because when we print the object by default  it returns some value,
* ex. Student@6d06d69c
*     className@hashCodeValueOfTheObject
*    so according to our requirement we can override it.
*
* 4. what is hashCode() method?
*      a. The default implementation of hashCode() in the Object class typically returns a value
*       derived from the object's memory address, but this is not guaranteed and can vary between
*       JVM implementations.
       b. When you override hashCode(), the hash code is calculated based on the fields of the object,
        and it no longer has any relationship with the memory address.

*
*  */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String departmantName;
    private int joinedYear;
    private String city;
    private int rank;

    public boolean equals(Student s){
       return this.id==s.id;
    }

    public int hashCode(){
        return this.id;
    }

    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age	+ ", gender=" + gender + ", departmantName=" + departmantName + ", joinedYear=" + joinedYear + ", city=" + city + ", rank=" + rank + "]";
    }
    public Student(int id, String firstName, String lastName, int age, String gender, String departmantName, int joinedYear, String city, int rank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.departmantName = departmantName;
        this.joinedYear = joinedYear;
        this.city = city;
        this.rank = rank;
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartmantName() {
        return departmantName;
    }

    public void setDepartmantName(String departmantName) {
        this.departmantName = departmantName;
    }

    public int getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(int joinedYear) {
        this.joinedYear = joinedYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
