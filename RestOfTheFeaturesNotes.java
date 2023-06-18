import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestOfTheFeaturesNotes {
//1.
//    Java provides two interfaces to sort objects using data members of the class:
//    1.Comparable
//    2.Comparator

//2.
//    Every Java Programmer is familiar with NullPointerException. It can crash your code.
//    And it is very hard to avoid it without using too many null checks. So, to overcome this,
//    Java 8 has introduced a new class Optional
//            in java.util package. It can help in writing a neat code
//    without using too many null checks.

//3.
//        static method in interface

    //4.
    //    forEach()

    public static void main(String[] args) {
        //for each
        List<Integer> l=new ArrayList<>(List.of(4,2,5,1,3));

        for (Integer x:
            l ) {
            System.out.println(x);
        }



//optional
       Optional<String> a= Optional.ofNullable("abc");
        System.out.println(a.isEmpty()?"absent":a.get());

//        Optional<String> a= Optional.ofNullable(null);
       // System.out.println(a.isEmpty()?"absent":a.get());
    }
}
