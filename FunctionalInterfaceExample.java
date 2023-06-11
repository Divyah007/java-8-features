


//Java Functional Interfaces
//        A functional interface is an interface that contains only one abstract method.
interface Name {
    void printName(String name);
}

    class Classic implements Name{
        @Override
        public  void printName(String name) {
            System.out.println("My name is "+name);
        }

    }

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Classic f=new Classic();
       f. printName("divya");
    }
}
