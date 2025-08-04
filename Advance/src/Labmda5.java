//lambda expression can only be used on funtional interface
//taking the previous example to understand lambda expression
@FunctionalInterface
interface B{
    void show();
}

@FunctionalInterface
interface C{
    void run(int i,int j);
}

@FunctionalInterface
interface D{
    int add(int i,int j);
}
public class Labmda5 {
    public static void main(String[] args) {
//        B b = new B() {
//            public void show() {
//                System.out.println("in Show");
//            }
//        };
        //Written the above anonymous class using lambda expression
         B b= () -> {
             System.out.println("In show");
         };
         b.show();

         C c=(i,j) -> {
             System.out.println(i+j);
         };
         c.run(5,6);

         D d = (i,j) -> {
             return i+j;
         };
         int result=d.add(4,2);
        System.out.println(result);

    }
}
