
//the Stream API is used to process collections of objects
//If we want to represent a group of objects as a single entity then we should go for collection.
//        But if we want to process objects from the collection then we should go for streams.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

//To filter out from the objects we do have a function named filter()
//        To collect elements we will be using Collectors.toList() to collect all the required elements
//filter() method
// map() method
// sorted() method
//findAny()
//        findFirst()
//        min()
//        max()
//        anyMatch()
//Collectors.toList()
//
public class StreamApiExample {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>(List.of(4,2,5,1,3));

        //1. filter
        //System.out.println( l.stream().filter(i->i%2==0).collect(Collectors.toList()));
        //o/p-->[4,2]

        //2. map()
        //System.out.println(l.stream().map(i->i*10).collect(Collectors.toList()));
        //o/p-->[40, 20, 50, 10, 30]

       // 3.sorted() asc
        System.out.println(l.stream().sorted().collect(Collectors.toList()));
        //o/p-->[1, 2, 3, 4, 5]



    }


}
