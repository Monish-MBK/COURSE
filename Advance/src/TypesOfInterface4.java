//3 types of interfaces in java 1.normal interface    2.Functional interface or single abstrac method    3.Marker
//1.It has more than 1 abtract method
//2.It has only 1 abstract method
//3.It has no method
@FunctionalInterface
interface A{
    void show();
}
public class TypesOfInterface4 {
    public static void main(String[] args) {
//Rather then creating a child class just for defining a abstract method we can define using anonymous child class
//While creating an anonymous child class we can actually create an object of interface class
//Semi colon at the end of anonymous class
        A a = new A(){
            public void show(){
                System.out.println("In show");
            }
        };
    }

}
