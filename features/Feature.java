package java8.features;

import java.util.*;
import java.util.stream.Collectors;

public class Feature {

    public static void main(String[] args) {

        //EQUALS AND HASHCODE METHOD

     /*   1. what is equals() method?
     ===================================

             Student s1=new Student(432);
            Student s2=new Student(432);

          a. The default implementation of equals() in the Object class compares the memory addresses
            (references) of the two objects to determine if they are the same instance.
            i.e by default
               sop(s1.equals(s2))-->false
             because (s1.equals(s2)) default implementation is (s1==s2)

           b. we can override equals() method of a class, if we want to compare the objects
           by values of field

           in Student class, overide equals method
                           public boolean equals(Student s){
                       return this.id==s.id;
                    }

           now,
           sop(s1.equals(s2))-->true
            because (s1.equals(s2)) works by checking if s1.getId and s2.getId are same or not,
            if same it returns true or false.


      */
        Student s1 = new Student(432);
        Student s2 = new Student(432);

        //System.out.println(s1.equals(s2));

        /*
        2. what is hashCode() method?
        =========================
*            a. The default implementation of hashCode() in the Object class typically returns a value
*       derived from the object's memory address, but this is not guaranteed and can vary between
*       JVM implementations.


            A.without overriding equals and hashcode method
               System.out.println(s1.equals(s2)); --->false
               System.out.println(s1.hashCode()==s2.hashCode()); --->false

               B. overrided equals and not overrided hashcode method
                in Student class, overide equals method
                           public boolean equals(Student s){
                       return this.id==s.id;
                    }
                 System.out.println(s1.equals(s2));--> true
                 System.out.println(s1.hashCode()==s2.hashCode());-->false

             b. When you override hashCode(), the hash code is calculated based on the fields of the object,
        and it no longer has any relationship with the memory address.

        overrided equals and overrided hashcode method in Student class

                           public boolean equals(Student s){
                             return this.id==s.id;
                             }

                        public int hashCode(){
                       return this.id;
                        }

                        System.out.println(s1.equals(s2)); -->true
                        System.out.println(s1.hashCode()==s2.hashCode());--> true

                A. The hashCode() method is used to generate a hash code for an object, which is an integer value.
            This hash code is used by hash-based data structures to efficiently store and retrieve objects.

                B. If two objects are equal according to the equals() method, they must have the same hash code.

           c. why If two objects are equal according to the equals() method, they must have the same hash code?
                A.If two objects are equal according to the equals() method then they must have the same hash code because
               for maintaining the data consistency and functionality of hash-based data structures,
                such as HashMap, HashSet, and Hashtable and also  and prevents data inconsistencies.
                B. ex. HashMap: Uses the hash code to determine the bucket in which to store the object. When an object
                 is retrieved, the hash code is used to find the bucket, and then equals() is used
                 to find the exact object within that bucket.
                C. If two objects are considered equal by the equals() method but have different hash codes,
                the collection might place them in different buckets.As a result, it would not correctly identify
                them as duplicates or handle retrieval operations properly.
                D. Maintaining this contract avoids issues with object retrieval, duplication, and
                consistency within hash-based collections.


         */

//        System.out.println(s1.equals(s2));
//        System.out.println(s1.hashCode()==s2.hashCode());

        //STREAM API PRACTICE QUESTIONS
        List<Student> studlist = Arrays.asList(
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

        //1. Find Students Whose First Name Starts with 'A'

        List<Student> listOfStudentsfirstNameStartsWithA = studlist.stream()
                .filter(s -> s.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
        // System.out.println(listOfStudentsfirstNameStartsWithA);

        //2.Group Students by Department Name
        Map<String, List<Student>> mapOfStudentsByDepartmentName = studlist.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName));
        // System.out.println(mapOfStudentsByDepartmentName);

        // 3. Count the Total Number of Students
        Long totalCount = studlist.stream()
                .count();
        //System.out.println(totalCount);

        //4.Find the Maximum Age
        // Note:  Integer.max() ,Integer.min() ,Integer.sum()

//        Optional<Integer> maxAge=studlist.stream()
//                .map(Student::getAge)
//                .reduce(Integer::max);
        //  System.out.println(maxAge.get());
        //        (or)

        // Note: mapToTnt has max,min,average,sum,.. methods
        OptionalInt maxAge = studlist.stream()
                .mapToInt(Student::getAge)
                .max();
//        System.out.println(maxAge.getAsInt());

        //5. Find All Unique Department Names:
        List<String> distinctDepartmentName = studlist.stream()
                .map(Student::getDepartmantName)
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(distinctDepartmentName);

        //6.Count Students in Each Department
        Map<String, Long> countOfEachStudentsPerDepartment = studlist.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        // System.out.println(countOfEachStudentsPerDepartment);

        //7. Find Students Below Age 30
        List<Student> studentsBelowAge30 = studlist.stream()
                .filter(s -> s.getAge() < 30)
                .collect(Collectors.toList());

//        System.out.println(studentsBelowAge30);

        //8. Find Students with Rank Between 50 and 100

        List<Student> studentsWithRankBetween50and100 = studlist.stream()
                .filter(s -> s.getRank() > 50 && s.getRank() < 100)
                .collect(Collectors.toList());

        // System.out.println(studentsWithRankBetween50and100);

        //9. Average Age of Male and Female Students
        Map<String, Double> averageAgeOfMaleAndFemaleStudents = studlist.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        // System.out.println(averageAgeOfMaleAndFemaleStudents);

        //10. Find Department with Maximum Number of Students:
        Map<String, Long> noOfStudentsDeparmentWiseMap = studlist.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));

        //s System.out.println(noOfStudentsDeparmentWiseMap.entrySet().stream().max(Map.Entry.comparingByValue()));

//       a. entrySet() method to iterate over the entries in the map
//        b. Map.Entry represents a single key-value pair in a Map.
//        It allows you to access and manipulate the key and value of an entry.

        //11. Find Students in Karnataka and Sort by Name
        List<Student> studentInKarnatakaAndSortedByFirstName = studlist.stream()
                .filter(s -> s.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());

        // System.out.println(studentInKarnatakaAndSortedByFirstName);


        //12.  Average Rank in Each Department
        Map<String, Double> averageRankInEachDepartmentMap =
                studlist.stream()
                        .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));

       // System.out.println(averageRankInEachDepartmentMap);

        //13.Find the Highest Rank (Lowest Value) in Each Department

        Map<String, Optional<Student>> higestRankInEachDepartmentMap =
                studlist.stream()
                        .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));

       // System.out.println(higestRankInEachDepartmentMap);

        //14.Sort Students by Rank

        List<Student> sortStudentsByRank=
                studlist.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
       // System.out.println(sortStudentsByRank);

       //15. Find the Student with the Second Highest Rank
        Optional<Student> secondHighesdtStudentsByRank=studlist.stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1).findFirst();
        System.out.println(secondHighesdtStudentsByRank.get());

    }
}
