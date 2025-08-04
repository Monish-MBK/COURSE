import java.util.*;

//Collection is an interface and list,Queue and Set are interfaces which implements collection
//List queue and set have got their own child classes ex arraylist, hashset, dequeue and so on
public class Collection10 {
    public static void main(String[] args) {
        //collection is an interface for which we cannot create an object but we are creating an object of its child interfaces[List] child class[Array list]
        Collection num = new ArrayList();
        num.add(10);
        num.add(20);
        num.add(30);
        //we do not need to use loops to print the values inside array list we can do it directly
        System.out.println(num);

        //No where we have mentioned the type of data and collection does not have any indexing
        //Collection store object type by default
        //List<Integer> num1 = Arrays.asList(40,50,60);   adding values to list directly
//        List<Student> students = new ArrayList<>(List.of(
//                new Student(1,"Virat","Cover Drive"),
//                new Student(2,"ABD","360 Shots"),
//                new Student(3,"Chris","Big Hitter")
//        ));                                             Dynamic type of arrayList to add value at anypoint
        //Through above type we can add values dirctly and also used add method after any time  
        List<Integer> num1 = new ArrayList<Integer>();
        num1.add(40);
        num1.add(50);
        num1.add(60);
        System.out.println(num1.indexOf(50));  //fetching the index value
        System.out.println(num1.get(2));       //fetching the value using index
        System.out.println(num1);

        //List supports duplicate values and it follows the order using indexing
        //set does not support duplicates and does not follows order and soes not have any indexing
        //Tree set provides a sorted list also but not the hashset

        Set<Integer> num2 = new HashSet<Integer>();
        num2.add(70);
        num2.add(80);
        num2.add(90);

        System.out.println(num2);   //You will not get in the same order
        //If you want to fetch individual numbers we can use loops
        for(Integer n : num2){
            System.out.println(n);
        }

        Set<Integer> num3 = new TreeSet<Integer>();
        num3.add(45);
        num3.add(56);
        num3.add(23);
        System.out.println(num3);   //You always get the sorted values

        //Collection implements Iterator interface which can be used to iterate through values
        Collection<Integer> num4 = new TreeSet<>();
        num4.add(64);
        num4.add(72);
        num4.add(55);
        num4.add(87);

        Iterator<Integer> values = num4.iterator();

        while (values.hasNext()){
            System.out.println(values.next());
        }

    }
}
