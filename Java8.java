import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
//https://www.linkedin.com/pulse/java-8-stream-api-commonly-asked-interview-questions-kumar-yadav-1mwcc/?trackingId=RJ6HVbkIRb%2B8ObZcnNkd8g%3D%3D
//stream api
public class Java8 {
    public static void main(String[] args) {
        List<Student> sl = Arrays.asList(
                new Student(1, "Rohit", "Kumar", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish", "Malag", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98)
        );

//==================================================================
        // 1. Find Students Whose First Name Starts with 'A'

        List<Student> s = sl.stream() //converts collections(list,..) to stream , to process the data
                .filter(i -> i.getFirstName().startsWith("A")) // condition i.e predicate is given as i/p and and returns a new stream consisting of elements that match the given predicate.
                .collect(Collectors.toList());// the result is returned in list

        // System.out.println(sl);
        //================================================

        //2. Group Students by Department Name,List<Students> -->only key

        Map<String, List<Student>> sm = sl.stream() // convert collection(list,..) to stream to process data
                .collect(Collectors.groupingBy(Student::getDepartmantName));
        // groupingBy-->takes input as key
        //Collectors.groupingBy--> returns map of "given key,list of objects of list datatype"
        //i.e, Map<String,List<Student>>
        //           dept


        //Student::getDepartmantName
        //The term "arbitrary object" is used because the actual object passed
        // in the parameter could be different each time the method reference is executed


        //System.out.println(sm);
        //=========================
        //3. Group Students by Department Name,count --->key,value

        Map<String, Long> smc = sl.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));

        // System.out.println(smc);
        //================================================
        // 4. Count the Total Number of Students
        Long l = sl.stream().count();

        // System.out.println("=="+l);
        //=================================
        // 5.Find the Maximum and minimum Age:

        // a. mapToInt ex. print only the age of the students
        // sl.stream().mapToInt(Student::getAge).forEach(System.out::println);
        //mapToInt is an intermediate operation that converts each element in the stream into an int.
        // it returns int stream so that we can use func. like max(),..

        //b.map ex. print only the age of the students
        //List<Integer> al= sl.stream().map(Student::getAge).collect(Collectors.toList());
        //System.out.println(al);

        //c. Print age and name of each student
        //  sl.stream()
        // .map(i -> i.getFirstName() + " " + i.getLastName() + ": " + i.getAge())  // Format each Student
        // .forEach(System.out::println);  // Print each formatted string
//min and max
//Integer maxAge=sl.stream().mapToInt(Student::getAge).max().getAsInt();
//
//        Integer minAge =sl.stream().mapToInt(Student::getAge).min().getAsInt();
//
//        System.out.println(minAge+" "+maxAge);

      //  sl.stream().mapToInt(Student::getAge).average()
        //6. . Find All Unique Department Names

        //  sl.stream().map(Student::getDepartmantName).distinct().forEach(System.out::println);
//=======
       Map<String,Long> d= sl.stream()
               .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));

       // System.out.println(d);

Map.Entry<String,Long> mi=d.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(mi);
    }
}
