import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach12 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,4,5,7,8);
        //normal for loop
        for (int i =0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }
        //Enhanced for loop
        for(Integer num : numbers){
            System.out.println(num);
        }
        //ForEach loop
        numbers.forEach(n-> System.out.println(n));



    }
}
//Explaining forEach loop
////ForEach accepts consumer type parameter soo we need to create an object of consumer but it is a functionalinterface we need to define its method
//Consumer<Integer> con=new Consumer<Integer>() {
//    @Override
//    public void accept(Integer n) {
//        System.out.println(n);
//    }
//};
//        numbers.forEach(con);    //passing the ref of consumer
//
////Now since this is a functional interface we can create a lambda expression to reduce the code
//Consumer<Integer> con = (Integer n) -> {
//    System.out.println(n);
//};
//        numbers.forEach(con);
//
////Now we can reduce the code into 1 line by removing the paramter type
//Consumer<Integer> con = n -> System.out.println(n);
//        numbers.forEach(con);
//
////Now rather than passing the ref we can directly pass the statements as parameter
//        numbers.forEach(n -> System.out.println(n));
