import org.w3c.dom.ls.LSOutput;

//String is immutable, if you try to update the value of an existing data it will basically create a new memory in the stack constant pool
//If two string variables have same data then both variables will be pointed to same memory in the SCP, different memory will not be allocated
//Sting Buffer and String Builder is used to achieve mutability
public class Hello4 {
    public static void main(String[] args) {
        String name = "Monish";
        System.out.println(name.charAt(3));

        StringBuffer sb = new StringBuffer("Monish");      //only syntax to create a sting buffer
        sb.append(" M B K");                               //Achieving mutability using append
        System.out.println(sb);
        String str = sb.toString();                        //converting string buffer to string

        //StingBuffer and StringBuilder both are same

        Mobile ref1 = new Mobile();
        ref1.name="Apple";
        ref1.cost=1500;
        Mobile ref2 = new Mobile();
        ref2.name = "Samsung";
        ref2.cost = 1300;
        Mobile.type="Smartphone";         //assigning value to static variable
        ref1.call();                      //type will be same for both the objects
        ref2.call();
        Mobile.show(ref1);                //passing object for static method

    }
}
//Static variables are created to have a common variable for all the objects
//if you update or alter the data it will be reflected in all the objects
//Static variables should always be called by its class name and not by any ref var
class Mobile {
    String name;
    int cost;
    static String type;
    public void call(){
        System.out.println(name+ " : "+cost+" : "+type);

    }
    //Static method cannot have non static variables directly, By passing the object through parameter we can use non static variables.
    //cattic methods should also be called by its class name
    public static void show(Mobile obj){
        System.out.println(obj.name+ " : "+obj.cost+" : "+type);
    }
}

