import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Optional is a class which can be used to handle null pointer exception
//it is used when the value of any type can be null or the type
public class OptionalClass14 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Monish","Kanishka","Apoorva");
        //using optional when the null value occurs orElse comments will be executed
        Optional<String> string=names.stream()
                .filter(string1 -> string1.contains("n"))
                .findFirst();
        System.out.println(string);
        System.out.println(string.orElse("Not found"));

        //if we do not want to have optional class
        String string1=names.stream()
                .filter(string2 -> string2.contains("n"))
                .findFirst()
                .orElse("Not found");
        System.out.println(string1);
    }
}
