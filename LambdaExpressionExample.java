import java.util.ArrayList;
import java.util.List;

//A lambda expression is a short block of code which takes in parameters
//        and returns a value. Lambda expressions are similar to methods, but they do not
//        need a name and they can be implemented right in the body of a method.
public class LambdaExpressionExample {
    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>(List.of(2,4,6,8,10));
        list.forEach((c)->{
            System.out.println(c);
        });

    }
}
