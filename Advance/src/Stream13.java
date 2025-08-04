import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Stream is basically used to perfom some operations on the data without altering the original data
//1 stream can only be used to perfom 1 operation , after that we cannot use the same stream we have to create a new stream to perform someother operation
public class Stream13 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(12,32,22,45,63);

        Stream<Integer> s1=number.stream();
        Stream<Integer> s2=s1.filter(n -> n%2==0);  //Removes all odd numbers
        Stream<Integer> s3=s2.map(n-> n*2);   //Doubling all the even numbers
        int result=s3.reduce(0,(c,e)->c+e);  //Reduce produces a single integer value and we are adding all the doubles even numbers
        System.out.println(result);


        //Now we can write all this in single line
        //Since the end result is single integer no need to create stream object
        int res = number.stream()
                        .filter(n -> n%2==0)
                        .map(n-> n*2)
                        .reduce(0,(c,e)->c+e);

        System.out.println(res);

        //if we want to add the values we can use sum method but for that we need to convert the value to int using mapToInt
        int r = number.stream()
                .filter(n -> n%2==0)
                .map(n -> n*2)
                .mapToInt(n -> n)
                .sum();
        System.out.println(r);



    }
}
//Explaining filter method same as forEach
//Predicate<Integer> p= new Predicate<Integer>() {
//    		public boolean test(Integer n) {
//    			return n%2==0;
//    			if(n%2==0)
//    				return true;
//    			else
//    				return false;
//    		}
//    	};
//
//    	Predicate<Integer> p= n-> n%2==0;
//      .filter(p);


//Explaining Map method
//    	Function<Integer, Integer> fun= new Function<Integer,Integer>() {
//    		public Integer apply(Integer n) {
//    			return n*2;
//    		}
//    	};
//
//    	Function<Integer,Integer> fun= n-> n*2;
//      .map(fun);

//In reduce the first parameter[0] is the intial value c and e are 2 values to perform action
//c and e will be updated at every iteration till the stream is empty