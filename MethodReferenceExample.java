import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//MethodReference
//Object :: methodName
public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(List.of(1,3,5,7));
        list.forEach(System.out::println);

        //another example
      // list.forEach(Objects::nonNull);
    }
}
