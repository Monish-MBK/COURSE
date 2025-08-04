import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> products = Arrays.asList("Laptop", "Pen", "Notebook", "Headphones", "Smartphone");

        List<String> str = products.stream()
                        .filter(product -> product.length() > 5)
                                .map(product -> product.toUpperCase())
                                        .sorted().toList();

        products.forEach(s1 ->System.out.println(s1));
        System.out.println(str);
        System.out.println(products);



    }
}