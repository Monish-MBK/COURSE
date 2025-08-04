import java.util.HashMap;
import java.util.Map;

//Map does not implements Collection, so it behaves differently
//Map contains key value pair and key should be unique
//Key basically works as set and value works as list
public class Map11 {
    public static void main(String[] args) {
        Map<String,Integer> students = new HashMap<>();
        students.put("Monish",99);
        students.put("Kanishka",90);
        students.put("Apoorva",80);
        students.put("Kanaka",78);
        students.put("Apoorva",92);

        System.out.println(students);

        System.out.println(students.keySet());
        for (String key : students.keySet()){
            System.out.println(key + " : " +students.get(key));
        }
    }
}
//Apart from hashmap we have hashtable the difference is hashtable is synchronized which is helpful while working with threads
